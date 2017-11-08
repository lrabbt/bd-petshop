package br.com.petshop.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.petshop.model.pessoa.Funcionario;
import br.com.petshop.model.pessoa.horario.Horario;
import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;

public class FuncHorarioDAO {
	
	public static List<HorarioDeTrabalho> consultaHorariosDeTrabalho(Funcionario funcionario) throws SQLException{
		Connection con = ConnectionFactory.getConexaoMySQL();

		// pode ser um join
		String sql = "SELECT * FROM funcionario_horario WHERE pessoa_reg_funcionario is not null";

		PreparedStatement stmt = con.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();
		List<HorarioDeTrabalho> funcsHorario = new ArrayList<>();

		while(rs.next()){
			Horario horario = HorarioDAO.consultaHorarioPorId(rs.getInt("horario_id"));
			Funcionario func = FuncionarioDAO.consultaFuncionarioPorRegistro(rs.getInt("pessoa_reg_funcionario"));
			HorarioDeTrabalho funcHorario = new HorarioDeTrabalho(horario,func, rs.getBoolean("disponivel"));
			funcsHorario.add(funcHorario);
		}
		rs.close();
		stmt.close();
		return funcsHorario;
	}

	public static List<HorarioDeTrabalho> consultaHorarioDeTrabalhoPorHorario(Horario horario) throws SQLException {
		Connection connection = ConnectionFactory.getConexaoMySQL();

		String sql = "SELECT * FROM funcionario_horario WHERE horario_id = ? AND disponivel = 1 AND pessoa_reg_funcionario is not null";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, horario.getId());

		ResultSet resultSet = preparedStatement.executeQuery();

		List<HorarioDeTrabalho> horariosDeTrabalho = new ArrayList<>();
		while (resultSet.next()){
			HorarioDeTrabalho horarioDeTrabalho;

			horarioDeTrabalho = new HorarioDeTrabalho(horario,
					FuncionarioDAO.consultaFuncionarioPorRegistro(resultSet.getInt("pessoa_reg_funcionario")),
					true);

			horariosDeTrabalho.add(horarioDeTrabalho);
		}

		resultSet.close();
		preparedStatement.close();
		return horariosDeTrabalho;
	}



	public static void atualizaDisponibilidade(Funcionario funcionario, Horario horario, boolean disponivel) throws SQLException {
		Connection connection = ConnectionFactory.getConexaoMySQL();

		String sql = "UPDATE funcionario_horario SET disponivel = ? WHERE pessoa_reg_funcionario = ? AND horario_id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setBoolean(1, disponivel);
		preparedStatement.setInt(2, funcionario.getRegistroFuncionario());
		preparedStatement.setInt(3, horario.getId());

		preparedStatement.executeUpdate();

		preparedStatement.close();
	}
}
