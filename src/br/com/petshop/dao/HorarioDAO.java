package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.model.pessoa.horario.Horario;

public class HorarioDAO {

	public static List<Horario> consultaHorarios() throws SQLException{
	Connection con = ConnectionFactory.getConexaoMySQL();

	// cria um preparedStatement
	String sql = "SELECT * FROM horario";

	PreparedStatement stmt = con.prepareStatement(sql);
	
	ResultSet rs = stmt.executeQuery();
	List<Horario> listaHorario = new ArrayList<Horario>();
	
		while(rs.next()){
			Horario horario = new Horario(rs.getDate("data"));
			listaHorario.add(horario);
		}
		rs.close();
		stmt.close();
		return listaHorario;
	}
}
