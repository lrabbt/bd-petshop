package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.petshop.model.pessoa.Cliente;
import br.com.petshop.model.servico.ServicoAgendado;

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
			ServicoAgendado servAg = null;

			while(rs.next()){
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
