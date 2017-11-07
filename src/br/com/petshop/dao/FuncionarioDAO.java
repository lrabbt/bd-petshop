package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

	public static List<String> consultaFuncionarios() throws SQLException{
		Connection con = ConnectionFactory.getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT nome FROM pessoa where reg_funcionario is not null";

		PreparedStatement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		List<String> nomeFuncionarios = new ArrayList<>();
		
			while(rs.next()){
				
				String nomeFunc =rs.getString("nome");
				nomeFuncionarios.add(nomeFunc);
			}
			rs.close();
			stmt.close();
			return nomeFuncionarios;
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
}
