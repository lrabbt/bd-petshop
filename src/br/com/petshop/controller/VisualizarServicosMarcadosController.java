package br.com.petshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.model.servico.ServicoAgendado;

@Controller
@RequestMapping("meusservicos")
public class VisualizarServicosMarcadosController {
	@RequestMapping("/")
	public ModelAndView loadMyServices(HttpSession session)
	{
		List<ServicoAgendado> servs;
	}
}
