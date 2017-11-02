package br.com.Petshop.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.Petshop.model.Client;
import br.com.Petshop.dao.ClientDAO;

@Controller
@RequestMapping("login")
public class LoginController {
	Client client = null;
	
	@ModelAttribute("client")
	public Client setUpLoginForm() {
		return new Client();
	}
	@GetMapping("/")
	public String login() {
		return "loginForm";
	}
	
	@RequestMapping("/authClient")
	public ModelAndView authClient(@ModelAttribute("client") Client client,HttpSession session) throws SQLException
	{
		ModelAndView modelAndView = new ModelAndView("loginForm");
		modelAndView.addObject("login", client);
		modelAndView.getModelMap().addAttribute("message", "Email ou senha incorretos!");
		
		try {
			ClientDAO dao = new ClientDAO();
			this.client = dao.autentica(client.getEmail(),client.getSenha());
			
			if(this.client != null)	{
				//adiciona na sessao
				session.setAttribute("clientLogado", this.client);
				//redireciona para controlador mapeado com a url "user"
				modelAndView = new ModelAndView("redirect:/");
			}
		}
		catch(SQLException e){
			modelAndView.getModelMap().addAttribute("message", "Houve um erro na transação!");
		}
		return modelAndView;
	}
}
