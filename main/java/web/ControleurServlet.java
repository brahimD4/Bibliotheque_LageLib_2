package web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import metier.historique;


import javax.xml.stream.events.Comment;

import dao.daoMouad.Ilibrary;
import dao.daoMouad.IlibraryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ControleurServlet extends HttpServlet{
	private Ilibrary metier;
	
	@Override
	public void init() throws ServletException {
		metier=new IlibraryImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if(path.equals("/historique.java")) {
			empruntModel mo=new empruntModel();
			List<historique> Historique=metier.Afficher();
			mo.setHistoriques(Historique);
			req.setAttribute("mo", mo);
			req.getRequestDispatcher("jsp/historique.jsp").forward(req, resp);
		}else if(path.equals("/chercher.java")) {
			String motCle=req.getParameter("motCle");
			empruntModel model=new empruntModel();
			model.setMotCle(motCle);
			List<historique> Historique=metier.chercher("%"+motCle+"%");
			model.setHistoriques(Historique);
			req.setAttribute("model", model);
			req.getRequestDispatcher("jsp/historique.jsp").forward(req, resp);
		}
		else {
			resp.sendError(resp.SC_NOT_FOUND);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
