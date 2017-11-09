package br.com.petshop.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.petshop.model.pessoa.horario.Horario;

public class HorarioDAO {

	public static List<Horario> consultaHorarios() throws SQLException{
	Connection con = ConnectionFactory.getConexaoMySQL();

	// cria um preparedStatement
	String sql = "SELECT * FROM horario";

	PreparedStatement stmt = con.prepareStatement(sql);
	
	ResultSet rs = stmt.executeQuery();
	List<Horario> listaHorario = new ArrayList<>();
	
	while(rs.next()){
		Horario horario = new Horario(rs.getInt("id"), rs.getTimestamp("data"));
		listaHorario.add(horario);
	}

	rs.close();
	stmt.close();
	return listaHorario;
	}

	public static Horario consultaHorarioPorId(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConexaoMySQL();

		String sql = "SELECT * FROM horario WHERE id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		Horario horario = null;

		if(resultSet.next()){
			horario = new Horario(resultSet.getInt("id"), resultSet.getTimestamp("data"));
		}

		resultSet.close();
		preparedStatement.close();
		return horario;
	}
}
