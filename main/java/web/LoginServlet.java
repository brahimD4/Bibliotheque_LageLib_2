package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import dao.daoBrahim.SinglotonConnection;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  String path=request.getServletPath(); 
		  if(path.equals("/home.java")) {
		 
		    request.getRequestDispatcher("jsp/accueil.jsp").forward(request, response);
		    
		  } else if(path.equals("/logout.java")) {
			  
			  HttpSession session=request.getSession();
			  session.removeAttribute("login");
			  response.sendRedirect(request.getContextPath()+"/home.java"); 
			  
		  }
		  
		  else {
		    	response.sendError(response.SC_NOT_FOUND);
		    }
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String path=request.getServletPath(); 
		  
		 
		  
			if(path.equals("/login.java")) {
				 HttpSession session=request.getSession();
				 
				Connection connection=SinglotonConnection.getConnection();
			    String email =request.getParameter("email");
			    String password =request.getParameter("password");
			    
				  
			    try {
			    	String Query="SELECT* FROM users WHERE email=? and passwd=? and role='user'";
					PreparedStatement ps=connection.prepareStatement(Query);
					ps.setString(1, email);
					ps.setString(2, password);
					ResultSet rs=ps.executeQuery(); 
					if(rs.next()){
						String username =rs.getString("username");
						session.setAttribute("login",username);
						response.sendRedirect(request.getContextPath()+"/jsp/utilisateur.jsp"); 
                       
						
					}else {
					    
						 response.sendRedirect(request.getContextPath()+"/jsp/login.jsp"); 
					}
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
           }else if(path.equals("/Enregistrer.java")) {
	           String username=request.getParameter("username");
	           String email=request.getParameter("email");
	           String password=request.getParameter("password");
	           
	
           }
		
        
        
        
}

}
