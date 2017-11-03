package br.com.petshop.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import br.com.petshop.model.pessoa.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.dao.ClienteDAO;

@Controller
@RequestMapping("login")
public class LoginController {
	Cliente cliente = null;
	
	@ModelAttribute("cliente")
	public Cliente setUpLoginForm() {
		return new Cliente();
	}
	@GetMapping("/")
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping("/authClient")
	public ModelAndView authClient(@ModelAttribute("cliente") Cliente cliente, HttpSession session) throws SQLException
	{
		ModelAndView modelAndView = new ModelAndView("loginForm");
		modelAndView.addObject("login", cliente);
		modelAndView.getModelMap().addAttribute("message", "Email ou senha incorretos!");
		
		try {
			ClienteDAO dao = new ClienteDAO();
			this.cliente = dao.autentica(cliente.getEmail(), cliente.getSenha());
			
			if(this.cliente != null)	{
				//adiciona na sessao
				session.setAttribute("clientLogado", this.cliente);
				//redireciona para controlador mapeado com a url "user"
				modelAndView = new ModelAndView("redirect:/");
			}
		}
		catch(SQLException e){
			modelAndView.getModelMap().addAttribute("message", "Houve um erro na transacao!");
		}
		return modelAndView;
	}
}
