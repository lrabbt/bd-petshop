package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionFactory {

	private static Connection conexaoMySql = null;

	public static String status = "N�o conectou...";

	//Metodo retorna conexao aberta, caso ela esteja fechada, retorna uma nova conexao
	public static Connection getConexaoMySQL() {
		if(conexaoMySql == null){

			Connection connection;          //atributo do tipo Connection

			try {

				//Carregando o JDBC Driver padr�o

				String driverName = "com.mysql.jdbc.Driver";

				Class.forName(driverName);

				//Configurando a nossa conex�o com um banco de dados//

				String serverName = "localhost:3306";    //caminho do servidor do BD

				String mydatabase = "petshop_bdi";        //nome do seu banco de dados

				String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

				String username = "root";        //nome de um usu�rio de seu BD

				String password = "root";      //sua senha de acesso

				connection = DriverManager.getConnection(url, username, password);


				//Testa sua conex�o//

				if (connection != null) {
					status = ("STATUS--->Conectado com sucesso!");
				} else {
					status = ("STATUS--->N�o foi possivel realizar conex�o");
				}

				conexaoMySql = connection;
			} catch (ClassNotFoundException e) {  //Driver n�o encontrado
				System.out.println("O driver expecificado nao foi encontrado.");
				return null;
			} catch (SQLException e) {
				//N�o conseguindo se conectar ao banco
				System.out.println("Nao foi possivel conectar ao Banco de Dados.");
				return null;
			}
		}

		return conexaoMySql;
	}

	//M�todo que retorna o status da sua conex�o//

	public static String statusConection() {
		return status;
	}

	//Metodo que fecha sua conexao
	public static boolean fecharConexao() {
		try {
			conexaoMySql.close();
			conexaoMySql = null;
			return true;
		}
		catch (SQLException e) {
			return false;
		}
	}

	//M�todo que reinicia sua conex�o//

	public static Connection reiniciarConexao() {
		fecharConexao();
		return ConnectionFactory.getConexaoMySQL();
	}
}
