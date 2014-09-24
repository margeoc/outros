package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost/estudo"; 
	private static final String LOGIN = "root"; 
	private static final String SENHA = ""; 
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, LOGIN, SENHA);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}
}