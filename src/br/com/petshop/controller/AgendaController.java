package br.com.petshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.model.Client;

@Controller
@RequestMapping("/")
public class AgendaController {
	
	@RequestMapping("/")
	public ModelAndView panelHome(HttpSession session) {
		ModelAndView modelAndView;
		Client client = (Client) session.getAttribute("clientLogado");
		
		modelAndView = new ModelAndView("home");
		modelAndView.addObject("client",client);
//		modelAndView.addObject(pet);
//		modelAndView.addObject(servico);
//		modelAndView.addObject(func);
//		modelAndView.addObject(calendar);
		
		return modelAndView;
	}
}
