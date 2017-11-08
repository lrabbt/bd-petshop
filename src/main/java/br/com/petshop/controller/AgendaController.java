package br.com.petshop.controller;

import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import br.com.petshop.dao.*;
import br.com.petshop.model.pessoa.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.pessoa.Cliente;
import br.com.petshop.model.pessoa.horario.Horario;
import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;
import br.com.petshop.model.servico.ServicoAgendado;
import br.com.petshop.model.servico.TipoDeServico;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class AgendaController {
	@ModelAttribute("horario")
	public Horario getMarcarServ(){
		return new Horario();
	}

	@ModelAttribute("agenda")
	public ServicoAgendado getAgenda(){
		return new ServicoAgendado();
	}

	@GetMapping("")
	public ModelAndView panelHome(HttpSession session) {
		ModelAndView modelAndView;
		Cliente cliente = (Cliente) session.getAttribute("clientLogado");

		try {
			List<Horario> horarios = HorarioDAO.consultaHorarios();

			modelAndView = new ModelAndView("home");
			modelAndView.addObject("cliente", cliente);
			modelAndView.addObject("horarios", horarios);

			modelAndView.addObject("agendaOk", true);
		} catch (SQLException e) {
			modelAndView = new ModelAndView("home");

			modelAndView.addObject("agendaOk", false);
		}

		return modelAndView;
	}

	@PostMapping("")
	public ModelAndView formularioServico(@ModelAttribute("horario") @Valid Horario horario,
										  BindingResult horarioBindingResult,
										  @ModelAttribute("agenda") ServicoAgendado agenda,
										  RedirectAttributes redirectAttributes,
										  HttpSession session) {
		ModelAndView modelAndView;
		Cliente cliente = (Cliente) session.getAttribute("clientLogado");

		try {
			horario = HorarioDAO.consultaHorarioPorId(horario.getId());
			HorarioDeTrabalho horarioDeTrabalho = new HorarioDeTrabalho();
			horarioDeTrabalho.setHorarioCompleto(horario);

			agenda.setHorarioDeTrabalho(horarioDeTrabalho);

			List<HorarioDeTrabalho> horariosDeTrabalho = FuncHorarioDAO.consultaHorarioDeTrabalhoPorHorario(horario);
			List<Funcionario> funcionarios = new ArrayList<>();

			for(HorarioDeTrabalho horarioDeTrabalhoAtual : horariosDeTrabalho){
				funcionarios.add(horarioDeTrabalhoAtual.getFuncionario());
			}


			List<Animal> pets = PetDAO.consultaPetsPorDono(cliente);
			List<TipoDeServico> servicos = ServicoDAO.consultaServicosOferecidos();

			if(horariosDeTrabalho.size() == 0){
				modelAndView = new ModelAndView("home");

				redirectAttributes.addFlashAttribute("message", "Sem funcionarios disponiveis no horario :(");
			} else {
				modelAndView = new ModelAndView("homeAgenda");
				modelAndView.addObject("cliente", cliente);
				modelAndView.addObject("petsMap", pets);
				modelAndView.addObject("servsMap", servicos);
				modelAndView.addObject("funcionarios", funcionarios);
				modelAndView.addObject("horarioId", horario.getId());
			}

			modelAndView.addObject("agendaOk", true);
		} catch (SQLException e) {
			modelAndView = new ModelAndView("home");

			modelAndView.addObject("agendaOk", false);
		}

		return modelAndView;
	}
	
	@PostMapping("agendaservico")
	public ModelAndView agendaServico(@ModelAttribute("agenda") @Valid ServicoAgendado servicoAgendado,
									  BindingResult servicoAgendadoBindingResult,
									  RedirectAttributes redirectAttributes,
									  HttpSession session) {
		ModelAndView modelAndView;

		Cliente cliente = (Cliente) session.getAttribute("clientLogado");

		servicoAgendado.getAnimalAtendido().setDono(cliente);
		System.out.println(servicoAgendado.getHorarioDeTrabalho().getHorarioCompleto().getId());

		try {
			AgendaDAO.insere(servicoAgendado);
			FuncHorarioDAO.atualizaDisponibilidade(servicoAgendado.getHorarioDeTrabalho().getFuncionario(), servicoAgendado.getHorarioDeTrabalho().getHorarioCompleto(), false);

			modelAndView = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("message", "Consulta cadastrada com sucesso!");
		} catch (SQLException e) {
			modelAndView = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("message", "Erro ao cadastrar consulta");
		}

		return modelAndView ;

	}
	
}
