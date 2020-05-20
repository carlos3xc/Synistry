package aiss.controller.popular;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.deviantart.PopularDeviantart;
import aiss.model.giphy.Example;
import aiss.model.resources.DeviantartResource;
import aiss.model.resources.GiphyResource;


public class PopularController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(PopularController.class.getName());
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
	RequestDispatcher rd = null;
		
		log.log(Level.FINE , "Searching categories of giphy =");
		
		GiphyResource gifscat = new GiphyResource();
		Example CategoriesResult = gifscat.getCategories();
		
		if(CategoriesResult != null) {
			rd=request.getRequestDispatcher("/views/popular.jsp");
			request.setAttribute("resultadosCategorias", CategoriesResult.getData());
			
		} else {
			log.log(Level.SEVERE , "eeee" + CategoriesResult);
			rd= request.getRequestDispatcher("/error.jsp");
			
		}
		
		
		
		log.log(Level.FINE, "Accediendo a populares");
		String token = (String) request.getSession().getAttribute("Deviantart-token");
		if (token!=null && !"".equals(token)) {
			DeviantartResource resource = new DeviantartResource(token);
			PopularDeviantart popularResults = resource.getPopular();
			
			if (popularResults!=null) {
				request.setAttribute("publicacionesPopular", popularResults.getResults());
				request.getRequestDispatcher("/views/popular.jsp").forward(request, response);
			} else {
				log.warning("Intentando obtener placebo sin token");
				request.getRequestDispatcher("/views/error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/AuthController/Deviantart").forward(request, response);
		}
		
		
		
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
