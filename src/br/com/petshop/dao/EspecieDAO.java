package br.com.petshop.dao;

import br.com.petshop.model.animal.Especie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
