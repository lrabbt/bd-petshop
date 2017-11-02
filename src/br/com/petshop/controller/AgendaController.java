package br.com.petshop.controller;

import javax.servlet.http.HttpSession;

import br.com.petshop.model.pessoa.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AgendaController {
	
	@RequestMapping("/")
	public ModelAndView panelHome(HttpSession session) {
		ModelAndView modelAndView;
		Cliente cliente = (Cliente) session.getAttribute("clientLogado");
		
		modelAndView = new ModelAndView("home");
		modelAndView.addObject("cliente", cliente);
//		modelAndView.addObject(pet);
//		modelAndView.addObject(servico);
//		modelAndView.addObject(func);
//		modelAndView.addObject(calendar);
		
		return modelAndView;
	}
}
