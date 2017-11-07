package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.model.servico.TipoDeServico;

public class ServicoDAO {
	
	public static List<TipoDeServico> consultaServicosOferecidos() throws SQLException{
	Connection con = ConnectionFactory.getConexaoMySQL();

	// cria um preparedStatement
	String sql = "SELECT * FROM tipo_servico";

	PreparedStatement stmt = con.prepareStatement(sql);
	
	ResultSet rs = stmt.executeQuery();
	List<TipoDeServico> listaServico = new ArrayList<TipoDeServico>();
	
		while(rs.next()){
			
			TipoDeServico servico = new TipoDeServico(rs.getString("nome"),rs.getLong("preco"));
			listaServico.add(servico);
		}
		rs.close();
		stmt.close();
		return listaServico;
	}
	
	public static int consultaServicoPorNome(String nome) throws SQLException{
		Connection con = ConnectionFactory.getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT id FROM tipo_servico where nome = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1,nome);
		
		ResultSet rs = stmt.executeQuery();
		
		int id_serv = 0;
			while(rs.next()){
				id_serv =rs.getInt("id");
			}
			rs.close();
			stmt.close();
			return id_serv;
	}
	
}
