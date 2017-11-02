package br.com.Petshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Petshop.model.Client;

@Controller
@RequestMapping("minhaconta")
public class VisualizarMeuPerfilController {
	@ModelAttribute("client")
	public Client setUpMinhaContaForm(HttpSession session) {
		Client client = (Client) session.getAttribute("clientLogado");
		return client;
	}
	@GetMapping("/")
	public String login() {
		return "minhaconta";
	}
	@RequestMapping("atualizar")
	public ModelAndView loadMyProfile(HttpSession session) {
		return null;
	}
}
