package br.com.petshop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import br.com.petshop.dao.AgendaDAO;
import br.com.petshop.model.pessoa.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.model.servico.ServicoAgendado;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("meusservicos")
public class VisualizarServicosMarcadosController {
	@GetMapping("")
	public ModelAndView loadMyServices(@ModelAttribute("message") String message,
                                       RedirectAttributes redirectAttributes,
                                       HttpSession session) {
		ModelAndView modelAndView;

        Cliente cliente = (Cliente) session.getAttribute("clientLogado");

        List<ServicoAgendado> servicosAgendados;
        try {
            servicosAgendados = AgendaDAO.consultaServicosPorCliente(cliente);

            modelAndView = new ModelAndView("meusservicos");
            if(servicosAgendados.size() == 0){
                modelAndView.addObject("temServicos", false);
                modelAndView.addObject("messageServicos", "Voce nao possui servicos cadastrados :/");
            } else {
                modelAndView.addObject("temServicos", true);
                modelAndView.addObject("servicos", servicosAgendados);
            }

            modelAndView.addObject("message", message);
        } catch (SQLException e) {
            modelAndView = new ModelAndView("redirect:/");
            redirectAttributes.addFlashAttribute("message","Houve um erro interno.Tente novamente mais tarde :(");
        }

        return modelAndView;
    }
}
