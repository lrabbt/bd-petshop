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
	
}
