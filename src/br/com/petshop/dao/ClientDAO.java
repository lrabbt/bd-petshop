package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.petshop.model.Client;

public class ClientDAO {
	public Client autentica(String emailform,String senhaform) throws SQLException {
		Connection con = new ConnectionFactory().getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT * FROM pessoa WHERE email = ? and senha = ?";

		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, emailform);
		stmt.setString(2, senhaform);
		// executa
		ResultSet rs = stmt.executeQuery();
		Client client = null;

		while(rs.next()){
			client = new Client();
			client.setClient(rs.getString("nome"),
					rs.getString("email"),
					rs.getString("data_nascimento"),
					rs.getString("cpf"),
					rs.getString("senha"),
					rs.getString("endereco"),
					rs.getString("telefone_1"),
					rs.getString("telefone_2"),
					rs.getString("telefone_3"));
		}
		stmt.close();  
		con.close();
		return client;
	}

	public void insereCliente(Client client) throws SQLException 
	{
		Connection con = new ConnectionFactory().getConexaoMySQL();

		// cria um preparedStatement
		String sql = "insert into pessoa" +
				" (cpf,nome,data_nascimento,email,senha,endereco,telefone_1,telefone_2,telefone_3)" +
				" values (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, client.getCpf());
		stmt.setString(2, client.getNome());
		stmt.setDate(3, java.sql.Date.valueOf(client.getDataNasc()));
		stmt.setString(4, client.getEmail());
		stmt.setString(5, client.getSenha());
		stmt.setString(6, client.getEndereco());
		stmt.setString(7, client.getTelefone1());
		stmt.setString(8, client.getTelefone2());
		stmt.setString(9, client.getTelefone3());

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		con.close();
	}
}
