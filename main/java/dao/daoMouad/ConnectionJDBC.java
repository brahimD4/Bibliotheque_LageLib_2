package dao.daoMouad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionJDBC {
	private static Connection connection;
	static {
		try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque2","root","admin");
	        }catch(Exception e){
	         System.out.println(e);
	        }
	}
	public static Connection getConnection() {
		return connection;
	}
}