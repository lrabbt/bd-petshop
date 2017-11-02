package br.com.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.dao.ClientDAO;
import br.com.petshop.model.Client;

@Controller
@RequestMapping("/cadastrar")
public class CadastroController {

	@ModelAttribute("client")
	public Client setUpRegisterForm() {
		return new Client();
	}
	@GetMapping("/")
	public String registration() {
		return "registerClientForm";
	}
	@RequestMapping("/cadastraCliente")
	public ModelAndView verifyClient(@ModelAttribute("client") Client client) throws Exception
	{
		ModelAndView modelAndView;
		
		ClientDAO dao = new ClientDAO();
		try {
		System.out.println(client.getCpf());
			dao.insereCliente(client);
			modelAndView = new ModelAndView("loginForm");
			modelAndView.getModelMap().addAttribute("message", "Cadastro efetuado com sucesso! Digite suas credenciais para logar!");
		}
		catch(Exception e){
			modelAndView = new ModelAndView("registerClientForm");
			modelAndView.getModelMap().addAttribute("message","O CPF ou o Email informados não possuem cadastro.Tente novamente!");
		}
		return modelAndView;
	}
	
}
