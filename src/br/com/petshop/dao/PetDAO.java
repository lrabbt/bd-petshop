package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.animal.Especie;
import br.com.petshop.model.enums.Sexo;
import br.com.petshop.model.pessoa.Cliente;

public class PetDAO {
	public List<Animal> consultaPetsPorDono(Cliente cliente) throws SQLException {
		Connection con = new ConnectionFactory().getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT * FROM animal WHERE cpf = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, cliente.getCpf());
		ResultSet rs = stmt.executeQuery();
		ArrayList<Animal> pets = null;
		
		while(rs.next()) {
			Especie especie = new Especie(rs.getString("especie"));
			Sexo sexo = null;
			if (rs.getString("sexo").equals("M")) {
				 sexo = sexo.M;
			}
			else {
				sexo = sexo.F;
			}
			Animal pet = new Animal(rs.getString("nome"),
					especie,
					rs.getString("raca"),
					sexo,
					rs.getInt("idade"),
					cliente
					);
		}
		return pets;
	}
}
