package br.com.petshop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.dao.FuncHorarioDAO;
import br.com.petshop.dao.FuncionarioDAO;
import br.com.petshop.dao.HorarioDAO;
import br.com.petshop.dao.PetDAO;
import br.com.petshop.dao.ServicoDAO;
import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.pessoa.Cliente;
import br.com.petshop.model.pessoa.horario.Horario;
import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;
import br.com.petshop.model.servico.TipoDeServico;

@Controller
@RequestMapping("/")
public class AgendaController {
	@RequestMapping("/")
	public ModelAndView panelHome(HttpSession session) throws SQLException {
		ModelAndView modelAndView;
		Cliente cliente = (Cliente) session.getAttribute("clientLogado");
		
		List<Animal> pets= PetDAO.consultaPetsPorDono(cliente);
		List<TipoDeServico> servicos = ServicoDAO.consultaServicosOferecidos(); 
		List<String> funcionarios = FuncionarioDAO.consultaFuncionarios();
		List<Horario> horarios = HorarioDAO.consultaHorarios();
		List<HorarioDeTrabalho> funcHorarios = FuncHorarioDAO.consultaHorarioDeTrabalho();
		
		modelAndView = new ModelAndView("home");
		modelAndView.addObject("cliente", cliente);
		modelAndView.addObject("pets",pets);
		modelAndView.addObject("servicos", servicos);
		modelAndView.addObject("funcionarios", funcionarios);
		modelAndView.addObject("horarios", horarios);
		modelAndView.addObject("funcHorarios", funcHorarios);
		
		return modelAndView;
	}
	
}
