package br.com.petshop.dao;

import br.com.petshop.model.animal.Especie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecieDAO {
    public static Especie consultaEspeciePorId(int id) throws SQLException {
        Connection con = ConnectionFactory.getConexaoMySQL();

        String sql = "SELECT * FROM especie WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultSet = stmt.executeQuery();

        Especie especie = null;

        while (resultSet.next()){
            especie = new Especie(resultSet.getString("nome"));
        }

        resultSet.close();
        stmt.close();
        return especie;
    }

    public static List<Especie> consultaEspecies() throws SQLException {
        Connection connection = ConnectionFactory.getConexaoMySQL();

        String sql = "SELECT * FROM especie";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Especie> especies = new ArrayList<>();

        while (resultSet.next()){
            especies.add(new Especie(resultSet.getString("nome")));
        }

        return especies;
    }
}
