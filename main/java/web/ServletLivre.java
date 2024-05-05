package web;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.Livre;

import java.io.IOException;
import java.sql.Date;

import dao.daoBrahim.IlivreDio;
import dao.daoBrahim.LivreDaoImpl;





public class ServletLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IlivreDio Dao ; 
       
public void init() throws ServletException{
       	Dao=new LivreDaoImpl();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		   String path=request.getServletPath();	
		   if(path.equals("/livres.liv")) {
			   
			    ModelLivre model=new ModelLivre();
			    model.setLivres(Dao.getTousLivres());
			    request.setAttribute("Touslivres", model);
				request.getRequestDispatcher("jsp/livres.jsp").forward(request, response);	
				
		   } else if(path.equals("/Supprimer.liv")) { 
			   int id =Integer.parseInt(request.getParameter("id"));
			   Dao.deleteLivre(id);
			  response.sendRedirect("livres.liv");
			  
		   }else  if(path.equals("/html/NewLivre.liv") && (request.getMethod().equals("POST"))){
			   String titre=request.getParameter("titre");
			   String auteur=request.getParameter("auteur");
			   String editeur=request.getParameter("editeur");
			   Date date= Date.valueOf(request.getParameter("date"));
			   Livre livre=new  Livre( titre, auteur, editeur, date);
			   Dao.Save(livre);
			   response.sendRedirect(request.getContextPath()+"/livres.liv");
			   
		   }else if(path.equals("/chercher.liv")) {
			   ModelLivre modele=new ModelLivre();
			   String motcle=request.getParameter("motCle");
			   modele.setMotCle(motcle);
			   modele.setLivres(Dao.recherche("%"+motcle+"%"));
			   request.setAttribute("livre_recherche", modele);
			   request.getRequestDispatcher("jsp/livres.jsp").forward(request, response);
			   
		   } else if(path.equals("/Edit.liv")) {
			   int id =Integer.parseInt(request.getParameter("id"));
			   Livre liv =Dao.getLivre(id);
			   request.setAttribute("LivreModifier", liv);
			   request.getRequestDispatcher("jsp/EditLivre.jsp").forward(request, response);
			   
		   }else if(path.equals("/UpdateLivre.liv")&& (request.getMethod().equals("POST")) ){
			   int id =Integer.parseInt(request.getParameter("id"));
			   String titre=request.getParameter("titre");
			   String auteur=request.getParameter("auteur");
			   String editeur=request.getParameter("editeur");
			   Date date= Date.valueOf(request.getParameter("date"));
			   Livre livre=new  Livre( titre, auteur, editeur, date);
			   livre.setId(id);
			   Dao.updateLivre(livre);
			   response.sendRedirect("livres.liv");
		   }
		   
		   
		   else {
		    	response.sendError(response.SC_NOT_FOUND);
		    }
				
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		doGet(request, response);
	}

}
