package br.com.petshop.controller;

import br.com.petshop.dao.ConnectionFactory;
import br.com.petshop.dao.EspecieDAO;
import br.com.petshop.dao.PetDAO;
import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.animal.Especie;
import br.com.petshop.model.enums.Sexo;
import br.com.petshop.model.pessoa.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cadastroPet")
public class CadastroAnimalController {
    @ModelAttribute("animal")
    public Animal getNewAnimal(){
        return new Animal();
    }

    @ModelAttribute("especies")
    public List<Especie> getEspecies() throws SQLException {
        return EspecieDAO.consultaEspecies();
    }

    @ModelAttribute("sexos")
    public Sexo[] getSexo(){
        return Sexo.values();
    }

    @GetMapping("/")
    public String registro(){
        return "registerPetForm";
    }

    @PostMapping("/")
    public ModelAndView registraNovoAnimal(@ModelAttribute("animal") @Valid Animal animal,
                                           BindingResult animalBinding, HttpSession session){
        ModelAndView modelAndView;

        animal.setDono((Cliente) session.getAttribute("clientLogado"));

        try {
            PetDAO.insere(animal);

            modelAndView = new ModelAndView("meuspets");
            modelAndView.getModelMap().addAttribute("message", "Cadastro efetuado com Sucesso!");
        } catch (SQLException e) {
            modelAndView = new ModelAndView("registerPetForm");
            modelAndView.getModelMap().addAttribute("message", "Erro ao cadastrar!");
        }

        return modelAndView;
    }
}
