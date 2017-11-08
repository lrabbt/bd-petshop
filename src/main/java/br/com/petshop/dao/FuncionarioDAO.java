package br.com.petshop.dao;

import br.com.petshop.model.pessoa.Funcionario;
import br.com.petshop.model.pessoa.horario.Horario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionarioDAO {

	public static List<Funcionario> consultaFuncionarios() throws SQLException{
		Connection con = ConnectionFactory.getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT * FROM pessoa WHERE reg_funcionario is not null";

		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		List<Funcionario> funcionarios = new ArrayList<>();
		
		while(rs.next()){
			Funcionario funcionario = new Funcionario(
					rs.getString("nome"),
					rs.getString("email"),
					rs.getDate("data_nascimento"),
					rs.getString("cpf"),
					rs.getString("senha"),
					rs.getString("endereco"),
					rs.getString("telefone_1"),
					rs.getString("telefone_2"),
					rs.getString("telefone_3"),
					rs.getInt("reg_funcionario")
			);

			funcionarios.add(funcionario);
		}

		rs.close();
		stmt.close();
		return funcionarios;
	}

	public static int consultaFuncionariosPorNome(String nome) throws SQLException{
		Connection con = ConnectionFactory.getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT reg_funcionario FROM pessoa where reg_funcionario is not null and nome = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,nome);

		ResultSet rs = stmt.executeQuery();

		int reg_func = 0;
			while(rs.next()){
				reg_func =rs.getInt("reg_funcionario");
			}
			rs.close();
			stmt.close();
			return reg_func;
	}

	public static Funcionario consultaFuncionarioPorRegistro(int registro) throws SQLException {
		Connection connection = ConnectionFactory.getConexaoMySQL();

		String sql = "SELECT * FROM pessoa WHERE reg_funcionario = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, registro);

		ResultSet resultSet = preparedStatement.executeQuery();

		Funcionario funcionario = null;

		if(resultSet.next()){
			funcionario = new Funcionario(
					resultSet.getString("nome"),
					resultSet.getString("email"),
					resultSet.getDate("data_nascimento"),
					resultSet.getString("cpf"),
					resultSet.getString("senha"),
					resultSet.getString("endereco"),
					resultSet.getString("telefone_1"),
					resultSet.getString("telefone_2"),
					resultSet.getString("telefone_3"),
					resultSet.getInt("reg_funcionario")
			);
		}

		resultSet.close();
		preparedStatement.close();
		return funcionario;
	}
}
