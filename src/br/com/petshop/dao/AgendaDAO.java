package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public static void insereAgendamento(String cpf, String nomeAnimal, int idServico, Date horarioAtendimento,
			int idFunc) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConexaoMySQL();

		// cria um preparedStatement
		String sql = "insert into servico_agendado" +
				" (animal_pessoa_cpf,animal_nome,funcionario_horario_pessoa_reg_funcionario,funcionario_horario_horario_data,tipo_servico_id)" +
				" values (?,?,?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1,cpf);
		stmt.setString(2, nomeAnimal);
		stmt.setInt(3, idFunc);
		stmt.setDate(4, (java.sql.Date) new Date(horarioAtendimento.getTime()));
		stmt.setInt(5, idServico);

		stmt.execute();

		System.out.println("Gravado!");

		stmt.close();
	}
	
	//alterar
		public static void consultaServicosPorCliente(String cpf) throws SQLException {
			Connection con = ConnectionFactory.getConexaoMySQL();

			// cria um preparedStatement
			String sql = "SELECT * FROM servico_agendado WHERE animal_pessoa_cpf = ?";

			PreparedStatement stmt = con.prepareStatement(sql);

			// preenche os valores
			stmt.setString(1, cpf);
			// executa
			ResultSet rs = stmt.executeQuery();
			List<ServicoAgendado> servs = new ArrayList<ServicoAgendado>();

			while(rs.next()){
				Animal animalAtendido = PetDAO.consultaPetPorNome(rs.getString("animal_nome"));
				TipoDeServico tipoDeServico = ServicoDAO.consultaServicoPorID(rs.getInt("tipo_servico_id"));
				Funcionario func = FuncionarioDAO.consultaFuncionariosPorID(rs.getInt("funcionario_horario_pessoa_reg_funcionario"));
				Horario horario = new Horario(rs.getDate("funcionario_horario_horario_data"));
				ServicoAgendado serv = new ServicoAgendado(Animal animalAtendido, TipoDeServico tipoDeServico, HorarioDeTrabalho horarioDeTrabalho);
//				servAg = new ServicoAgendado(rs.getString("nome"),
//						rs.getString("email"),
//						rs.getDate("data_nascimento"),
//						rs.getString("cpf"),
//						rs.getString("senha"),
//						rs.getString("endereco"),
//						rs.getString("telefone_1"),
//						rs.getString("telefone_2"),
//						rs.getString("telefone_3"));
			}

			rs.close();
			stmt.close();
//			return cliente;
		}
	

}
