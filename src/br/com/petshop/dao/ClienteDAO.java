package br.com.petshop.dao;

import java.sql.*;

import br.com.petshop.model.pessoa.Cliente;

public class ClienteDAO {
	public Cliente autentica(String emailform, String senhaform) throws SQLException {
		Connection con = new ConnectionFactory().getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT * FROM pessoa WHERE email = ? and senha = ?";

		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, emailform);
		stmt.setString(2, senhaform);
		// executa
		ResultSet rs = stmt.executeQuery();
		Cliente cliente = null;

		while(rs.next()){
			cliente = new Cliente(rs.getString("nome"),
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
		return cliente;
	}

	public void insereCliente(Cliente cliente) throws SQLException
	{
		Connection con = new ConnectionFactory().getConexaoMySQL();

		// cria um preparedStatement
		String sql = "insert into pessoa" +
				" (cpf,nome,data_nascimento,email,senha,endereco,telefone_1,telefone_2,telefone_3)" +
				" values (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, cliente.getCpf());
		stmt.setString(2, cliente.getNome());
		stmt.setTimestamp(3, new Timestamp(cliente.getDataNasc().getTime()));
		stmt.setString(4, cliente.getEmail());
		stmt.setString(5, cliente.getSenha());
		stmt.setString(6, cliente.getEndereco());
		stmt.setString(7, cliente.getTelefone1());
		stmt.setString(8, cliente.getTelefone2());
		stmt.setString(9, cliente.getTelefone3());

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		con.close();
	}
}
