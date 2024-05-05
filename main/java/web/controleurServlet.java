package web;

import java.io.IOException;
import java.util.List;

import dao.IproductDao;
import dao.ProductDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mitier.Product;

public class controleurServlet extends HttpServlet{
	private IproductDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ProductDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		if(path.equals("/index.do")) {
			req.getRequestDispatcher("products.jsp").forward(req, resp);
		}else if(path.equals("/chercher.do")){
			String motCle=req.getParameter("motCle");
			ProductModel model=new ProductModel();
			model.setMotCle(motCle);
			List<Product> products=metier.productsByMC("%"+motCle+"%");
			model.setProducts(products);
			req.setAttribute("model", model);
			req.getRequestDispatcher("products.jsp").forward(req, resp);
		}else if(path.equals("/ajouter.do")) {
			req.getRequestDispatcher("ajouter.jsp").forward(req, resp);
		}else if(path.equals("/save.do")&&(req.getMethod().equals("post"))){
			String name=req.getParameter("name");
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			double price=Double.parseDouble(req.getParameter("price"));
			Product p=metier.save(new Product(name,quantity,price));
			req.setAttribute("product",p);
			req.getRequestDispatcher("Confirmation.jsp").forward(req, resp);
		}else {
			resp.sendError(resp.SC_NOT_FOUND);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}