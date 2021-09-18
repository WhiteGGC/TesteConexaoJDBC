package application.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {
	
	private Connection c;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//127.0.0.1:1433
		c = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;DatabaseName=conexaojdbc;namedPipes=true", 
				"gustavo", "123456789");
		System.out.println("Conexão OK");
		return c;
	}
	
}
