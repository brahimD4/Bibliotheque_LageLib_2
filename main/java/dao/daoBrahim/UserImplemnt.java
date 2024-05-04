package dao.daoBrahim;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import metier.User;

public class UserImplemnt implements Iuser {

	@Override
	public User save(User user) {
    Connection connection=SinglotonConnection.getConnection();
		
		
		try {
			String Query="INSERT INTO users(username,passwd,email)VALUES(?,?,?)";
			  PreparedStatement ps=connection.prepareStatement(Query);
			  ps.setString(1, user.getUsername());
			  ps.setString(2, user.getPassword());
			  ps.setString(3, user.getEmail());
			  ps.executeUpdate(); 
			  
			  PreparedStatement ps2=connection.prepareStatement("SELECT MAX(user_id) AS MAXID FROM users");
			  ResultSet rs=ps2.executeQuery(); 
			  if(rs.next()) { 
				  user.setId(rs.getInt("MAXID"));
			
			  } 
			  ps.close(); 
			  } catch (SQLException e) { 
			  e.printStackTrace(); 
			  }
			  
			 
			  

	
		
		return user;
	}

}
