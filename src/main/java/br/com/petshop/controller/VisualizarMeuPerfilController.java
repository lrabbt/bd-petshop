package br.com.petshop.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.model.pessoa.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("minhaconta")
public class VisualizarMeuPerfilController {
	@ModelAttribute("cliente")
	public Cliente setUpMinhaContaForm(HttpSession session) 
	{
		return (Cliente) session.getAttribute("clientLogado");
	}
	
	
	@GetMapping("")
	public String login() {
		return "minhaconta";
	}

	@DeleteMapping("")
	public ModelAndView deletaClienteAtual(RedirectAttributes redirectAttributes,
										   HttpSession httpSession){
		ModelAndView modelAndView;

		Cliente cliente = (Cliente) httpSession.getAttribute("clientLogado");

		try {
			ClienteDAO.deleta(cliente);
			httpSession.setAttribute("clientLogado", null);

			modelAndView = new ModelAndView("redirect:/login/");
			redirectAttributes.addFlashAttribute("message", "Cliente '" + cliente.getNome() + "' desregistrado com sucesso!");
		} catch (SQLException e) {
			modelAndView = new ModelAndView("redirect:/minhaconta/");
			redirectAttributes.addFlashAttribute("message", "Falha ao desregistrar cliente!");
		}

		return modelAndView;
	}
	
	@RequestMapping("atualizar")
	public ModelAndView loadMyProfile(@ModelAttribute("cliente") Cliente cliente,HttpSession session) 
	{
		ModelAndView modelAndView;
		ClienteDAO daoC = new ClienteDAO();
		try {
			daoC.atualiza(cliente);
			modelAndView = new ModelAndView("minhaconta");
			modelAndView.getModelMap().addAttribute("message", "Dados de Cadastro atualizados com sucesso!");
		}
		catch(Exception e){
			modelAndView = new ModelAndView("minhaconta");
			modelAndView.getModelMap().addAttribute("message","Houve um erro interno.Tente novamente mais tarde :(");
		}
		return modelAndView;
	}
}
