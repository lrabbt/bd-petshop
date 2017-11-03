package br.com.petshop.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.model.pessoa.Cliente;

@Controller
@RequestMapping("cadastrar")
public class CadastroController {

	@ModelAttribute("cliente")
	public Cliente setUpRegisterForm() {
		return new Cliente();
	}
	@GetMapping("/")
	public String registration() {
		return "registerClientForm";
	}
	@RequestMapping("/cadastraCliente") 
	public ModelAndView verifyClient(@ModelAttribute("cliente") Cliente cliente) throws SQLException
	{
		ModelAndView modelAndView;
		System.out.println(cliente.getCpf());
		
		ClienteDAO daoC = new ClienteDAO();
		try {
			daoC.insere(cliente);
			System.out.println(cliente.getCpf());
			modelAndView = new ModelAndView("loginForm");
			modelAndView.getModelMap().addAttribute("message", "Cadastro efetuado com sucesso! Digite suas credenciais para logar!");
		}
		catch(Exception e){
			modelAndView = new ModelAndView("registerClientForm");
			modelAndView.getModelMap().addAttribute("message","O CPF ou o Email informados ja possuem cadastro.Tente novamente!");
		}
		return modelAndView;
	}
	
}
