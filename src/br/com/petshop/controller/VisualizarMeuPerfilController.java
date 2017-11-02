package br.com.petshop.controller;

import javax.servlet.http.HttpSession;

import br.com.petshop.model.pessoa.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("minhaconta")
public class VisualizarMeuPerfilController {
	@ModelAttribute("cliente")
	public Cliente setUpMinhaContaForm(HttpSession session) {
		Cliente cliente = (Cliente) session.getAttribute("clientLogado");
		return cliente;
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
