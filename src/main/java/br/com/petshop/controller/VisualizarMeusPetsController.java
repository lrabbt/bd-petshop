package br.com.petshop.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import br.com.petshop.dao.EspecieDAO;
import br.com.petshop.model.animal.Especie;
import br.com.petshop.model.enums.Sexo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.dao.PetDAO;
import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.pessoa.Cliente;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("meuspets")
public class VisualizarMeusPetsController {
	@ModelAttribute("cliente")
	public Cliente clienteDeSessao(HttpSession httpSession){
		return (Cliente) httpSession.getAttribute("clientLogado");
	}

	@RequestMapping("/")
	public ModelAndView loadMyPets(HttpSession session)
	{
		List<Animal> pets;
		ModelAndView modelAndView = new ModelAndView("meuspets");
		Cliente cliente = (Cliente) session.getAttribute("clientLogado");

		try {
			pets = PetDAO.consultaPetsPorDono(cliente);

			if(pets.size() == 0){
				modelAndView.addObject("temPets", false);
				modelAndView.addObject("messagePets", "Voce nao possui pets cadastrados :/");
			} else {
				modelAndView.addObject("temPets", true);
				modelAndView.addObject("pets", pets);
			}
		}
		catch(Exception e){
			modelAndView.getModelMap().addAttribute("message","Houve um erro interno.Tente novamente mais tarde :(");
		}
		return modelAndView;
	}

	@GetMapping("/{nomePet}")
	public ModelAndView editarPet(@PathVariable(value = "nomePet") String nomePet,
								  @ModelAttribute("cliente") Cliente cliente,
								  RedirectAttributes redirectAttributes,
								  HttpSession httpSession) {
		Animal animal;
		ModelAndView modelAndView;

		try {
			animal = PetDAO.consultaPetPorDonoENome(cliente, nomePet);

			if(animal == null) {
				modelAndView = new ModelAndView("redirect:/meuspets/");
				redirectAttributes.addFlashAttribute("message", "Animal não cadastrado :(");
			} else {
				List<Especie> especies = EspecieDAO.consultaEspecies();
				modelAndView = new ModelAndView("updatePetForm");
				modelAndView.addObject("especies", especies);
				modelAndView.addObject("nomeAntigoAnimal", nomePet);

				modelAndView.addObject("animal", animal);
			}
		} catch (SQLException e) {
			modelAndView = new ModelAndView("redirect:/meuspets/");
			redirectAttributes.addFlashAttribute("message", "Erro no servidor");
		}

		return modelAndView;
	}

	@PostMapping("/{nomePet}")
	public ModelAndView atualizarPet(@PathVariable(value = "nomePet") String nomeAntigoPet,
								  @ModelAttribute("cliente") Cliente cliente,
								  @ModelAttribute("animal") @Valid Animal animal,
								  BindingResult animalBindingResult,
								  RedirectAttributes redirectAttributes,
								  HttpSession httpSession) {
		ModelAndView modelAndView;

		animal.setDono(cliente);

		try {
			PetDAO.atualiza(animal, nomeAntigoPet);

			modelAndView = new ModelAndView("redirect:/meuspets/");
			redirectAttributes.addFlashAttribute("message", animal.getNome() + " atualizad" + (animal.getSexo() == Sexo.M ? "o" : "a") + " com sucesso!");
		} catch (SQLException e) {
			modelAndView = new ModelAndView("redirect:/meuspets/" + nomeAntigoPet);
			redirectAttributes.addFlashAttribute("message", "Erro no cadastro!");
		}

		return modelAndView;
	}
}
