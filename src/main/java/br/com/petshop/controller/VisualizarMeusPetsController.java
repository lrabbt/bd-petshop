package br.com.petshop.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.dao.PetDAO;
import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.pessoa.Cliente;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("meuspets")
public class VisualizarMeusPetsController {
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
}
