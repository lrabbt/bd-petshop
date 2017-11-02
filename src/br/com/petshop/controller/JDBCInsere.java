package br.com.petshop.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.petshop.config.ConnectionFactory;

@Controller
@RequestMapping("/")
public class JDBCInsere {
	@RequestMapping("/")
    public String main() throws SQLException {

        // conectando
        Connection con = new ConnectionFactory().getConexaoMySQL();

        // cria um preparedStatement
        String sql = "insert into contatos" +
                " (nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);

        // preenche os valores
        stmt.setString(1, "Caelum");
        stmt.setString(2, "contato@caelum.com.br");
        stmt.setString(3, "R. Vergueiro 3185 cj57");
        stmt.setDate(4, new java.sql.Date(
                Calendar.getInstance().getTimeInMillis()));

        // executa
        stmt.execute();
        stmt.close();

        System.out.println("Gravado!");

        con.close();
        
        return "helloworld";
    }
}
