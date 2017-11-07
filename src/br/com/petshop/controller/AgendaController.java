package br.com.petshop.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.petshop.dao.AgendaDAO;
import br.com.petshop.dao.FuncHorarioDAO;
import br.com.petshop.dao.FuncionarioDAO;
import br.com.petshop.dao.HorarioDAO;
import br.com.petshop.dao.PetDAO;
import br.com.petshop.dao.ServicoDAO;
import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.pessoa.Cliente;
import br.com.petshop.model.pessoa.horario.Horario;
import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;
import br.com.petshop.model.servico.ServicoAgendado;
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
		
		int i;
		Map< String, String > petsMap = new HashMap<String, String>();
		Map< String, String > servMap = new HashMap<String, String>();
		Map< String, String > funcsMap = new HashMap<String, String>();
		Map< String, String > horasMap = new HashMap<String, String>();
		Map< String, String > funcHorasMap = new HashMap<String, String>();
		
		for(i=0;i<pets.size();i++) {
			petsMap.put(pets.get(i).getNome(),pets.get(i).getNome());
		}
		
		for(i=0;i<servicos.size();i++) {
			servMap.put(servicos.get(i).getNome(),servicos.get(i).getNome());
		}
		
		for(i=0;i<funcionarios.size();i++) {
			funcsMap.put(funcionarios.get(i),funcionarios.get(i));
		}
		
		for(i=0;i<horarios.size();i++) {
			horasMap.put(horarios.get(i).getDataCompleta().toString(),horarios.get(i).getDataCompleta().toString());
		}
		
		
		
		
		modelAndView = new ModelAndView("home");
//		modelAndView.addObject("cliente", cliente);
		modelAndView.addObject("petsMap",petsMap);
		modelAndView.addObject("servsMap", servMap);
		modelAndView.addObject("funcsMap", funcsMap);
		modelAndView.addObject("horasMap", horasMap);
		modelAndView.addObject("marcarServ", new ServicoAgendado());
//		modelAndView.addObject("funcHorarios", funcHorarios);
		
		return modelAndView;
	}
	
	@RequestMapping("agendaservico")
	public ModelAndView agendaServico(@ModelAttribute("marcarServ")ServicoAgendado servAg, HttpSession session) throws SQLException 
	{
		Cliente cliente = (Cliente) session.getAttribute("clientLogado");
		
		String cpf = cliente.getCpf();
		String nomeAnimal = servAg.getAnimalAtendido().getNome();
		int idServico = ServicoDAO.consultaServicoPorNome(servAg.getTipoDeServico().getNome());
		Date horarioAtendimento = servAg.getHorarioDeTrabalho().getHorarioCompleto().getDataCompleta();
		int idFunc = FuncionarioDAO.consultaFuncionariosPorNome(servAg.getHorarioDeTrabalho().getFuncionario().getNome());
//		try {
			AgendaDAO.insereAgendamento(cpf,nomeAnimal,idServico,horarioAtendimento,idFunc);
//		}
//		catch{
//			
//		}
		return null;
		
	}
	
}
