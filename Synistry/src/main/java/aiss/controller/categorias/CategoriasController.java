package aiss.controller.categorias;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import aiss.model.giphy.GiphySearch;

import aiss.model.resources.GiphyResource;


public class CategoriasController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(CategoriasController.class.getName());
	
	public CategoriasController() {
		 super();
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		RequestDispatcher hd = null;
		
		log.log(Level.FINE , "Searching categories " );
		GiphyResource cat = new GiphyResource();
		GiphySearch gifsCategory = cat.getCategories();
		
		
		if(gifsCategory != null) {
			
			hd=request.getRequestDispatcher("/views/popular.jsp");
			request.setAttribute("categorias", gifsCategory.getData());
		} else {
			
			
			hd=request.getRequestDispatcher("/error.jsp");
		}
		hd.forward(request, response);	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}