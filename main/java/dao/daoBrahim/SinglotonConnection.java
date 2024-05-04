package dao.daoBrahim;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SinglotonConnection {

	private static Connection connection;
	
	static {
		String url="jdbc:mysql://localhost:3306/bibliotheque";
		String username="root";
		String password="root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =DriverManager.getConnection(url,username,password);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
	}
		
	
}
	
	public static Connection getConnection(){
	
		return connection;
	}
	}
