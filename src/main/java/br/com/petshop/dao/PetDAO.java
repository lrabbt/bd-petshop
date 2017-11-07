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
	public static void insere(Animal animal) throws SQLException {
		Connection connection = ConnectionFactory.getConexaoMySQL();

		String especieSql = "SELECT * FROM especie WHERE id = ?";

		PreparedStatement especiePreparedStatement = connection.prepareStatement(especieSql);
		especiePreparedStatement.setString(1, animal.getNome());

		ResultSet especieResultSet = especiePreparedStatement.executeQuery();

		int especieId = especieResultSet.getInt("id");

		String sql = "INSERT INTO `animal` (`pessoa_cpf`, `nome`, `especie_id`, `sexo`, `idade`, `maturidade`, `raca`, `saude`) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, animal.getDono().getCpf());
		preparedStatement.setString(2, animal.getNome());
		preparedStatement.setInt(3, especieId);
		preparedStatement.setString(4, animal.getSexo().getSexo());
		preparedStatement.setInt(5, animal.getIdade());
		preparedStatement.setString(6, animal.getMaturidade());
		preparedStatement.setString(7, animal.getRaca());
		preparedStatement.setString(8, animal.getSaude());
	}

	public static List<Animal> consultaPetsPorDono(Cliente cliente) throws SQLException {
		Connection con = ConnectionFactory.getConexaoMySQL();

		// cria um preparedStatement
		String sql = "SELECT * FROM animal WHERE pessoa_cpf = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, cliente.getCpf());

		ResultSet rs = stmt.executeQuery();

		List<Animal> pets = new ArrayList<>();

		while(rs.next()) {
//			Retorna especie
			int especie_id = rs.getInt("especie_id");
			Especie especie = EspecieDAO.consultaEspeciePorId(especie_id);

//			Escolhe sexo
			Sexo sexo = Sexo.qualSexo(rs.getString("sexo"));

//			Cria instancia de animal
			Animal pet = new Animal(
					rs.getString("nome"),
					especie,
					rs.getString("raca"),
					sexo,
					rs.getInt("idade"),
					rs.getString("maturidade"),
					rs.getString("saude"),
					cliente
					);

			pets.add(pet);
		}

		rs.close();
		stmt.close();
		return pets;
	}
}
