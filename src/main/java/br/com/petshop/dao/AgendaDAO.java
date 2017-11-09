package br.com.petshop.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.pessoa.Cliente;
import br.com.petshop.model.pessoa.Funcionario;
import br.com.petshop.model.pessoa.horario.Horario;
import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;
import br.com.petshop.model.servico.ServicoAgendado;
import br.com.petshop.model.servico.TipoDeServico;

public class AgendaDAO {

	public static void insere(ServicoAgendado servicoAgendado) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConexaoMySQL();

		// cria um preparedStatement
		String sql = "insert into servico_agendado" +
				" (animal_pessoa_cpf, animal_nome, tipo_servico_id, funcionario_horario_pessoa_reg_funcionario, funcionario_horario_horario_id)" +
				" values (?,?,?,?,?)";

		int servicoId = ServicoDAO.consultaServicoPorNome(servicoAgendado.getTipoDeServico().getNome());

		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, servicoAgendado.getAnimalAtendido().getDono().getCpf());
		stmt.setString(2, servicoAgendado.getAnimalAtendido().getNome());
		stmt.setInt(3, servicoId);
		stmt.setInt(4, servicoAgendado.getHorarioDeTrabalho().getFuncionario().getRegistroFuncionario());
		stmt.setInt(5, servicoAgendado.getHorarioDeTrabalho().getHorarioCompleto().getId());

		stmt.executeUpdate();

		System.out.println("Gravado!");

		stmt.close();
	}

	//alterar
		public static List<ServicoAgendado> consultaServicosPorCliente(Cliente cliente) throws SQLException {
			Connection con = ConnectionFactory.getConexaoMySQL();

			// cria um preparedStatement
			String sql = "SELECT * FROM servico_agendado WHERE animal_pessoa_cpf = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			// preenche os valores
			stmt.setString(1, cliente.getCpf());
			// executa
			ResultSet rs = stmt.executeQuery();
			List<ServicoAgendado> servicosAgendados = new ArrayList<>();

			while(rs.next()){
				Animal animalAtendido = PetDAO.consultaPetPorDonoENome(cliente, rs.getString("animal_nome"));
				TipoDeServico tipoDeServico = ServicoDAO.consultaServicoPorId(rs.getInt("tipo_servico_id"));
				Funcionario func = FuncionarioDAO.consultaFuncionarioPorRegistro(rs.getInt("funcionario_horario_pessoa_reg_funcionario"));
				Horario horario = HorarioDAO.consultaHorarioPorId(rs.getInt("funcionario_horario_horario_id"));
				ServicoAgendado serv = new ServicoAgendado(
						animalAtendido,
						tipoDeServico,
						new HorarioDeTrabalho(horario, func, false)
				);
//
				servicosAgendados.add(serv);
			}

			rs.close();
			stmt.close();
			return servicosAgendados;
		}
	

}
