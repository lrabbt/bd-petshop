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

@Controller
@RequestMapping("meuspets")
public class VisualizarMeusPetsController {
	@RequestMapping("/")
	public ModelAndView loadMyPets(HttpSession session) 
	{
		List<Animal> pets;
		ModelAndView modelAndView = new ModelAndView("meuspets");;
		Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
		PetDAO daoP = new PetDAO();
		try {
			pets = daoP.consultaPetsPorDono(cliente);	
			modelAndView.addObject("pets",pets);
			modelAndView.getModelMap().addAttribute("message", "Dados de Cadastro atualizados com sucesso!");
		}
		catch(Exception e){
			modelAndView.getModelMap().addAttribute("message","Houve um erro interno.Tente novamente mais tarde :(");
		}
		return modelAndView;
	}
}
