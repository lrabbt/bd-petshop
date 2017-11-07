package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.model.pessoa.Funcionario;
import br.com.petshop.model.pessoa.horario.Horario;
import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;

public class FuncHorarioDAO {
	
	public static List<HorarioDeTrabalho> consultaHorarioDeTrabalho() throws SQLException{
		Connection con = ConnectionFactory.getConexaoMySQL();

		// pode ser um join
		String sql = "SELECT b.nome, a.horario_data, a.disponivel FROM funcionario_horario a, pessoa b WHERE a.pessoa_reg_funcionario = b.reg_funcionario ";

		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		List<HorarioDeTrabalho> funcsHorario = new ArrayList<HorarioDeTrabalho>();
		
			while(rs.next()){
				Horario horario = new Horario(rs.getDate("horario_data"));
				Funcionario func = new Funcionario(rs.getString("nome"));
				HorarioDeTrabalho funcHorario = new HorarioDeTrabalho(horario,func, rs.getBoolean("disponivel"));
				funcsHorario.add(funcHorario);
			}
			rs.close();
			stmt.close();
			return funcsHorario;
		}

}
