package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.deviantart.PopularDeviantart;
import aiss.model.resources.DeviantartResource;


public class popularDeviantartController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(popularDeviantartController.class.getName());
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		log.log(Level.FINE, "Accediendo a populares");
		String token = (String) request.getSession().getAttribute("Deviantart-token");
		if (token!=null && !"".equals(token)) {
			DeviantartResource resource = new DeviantartResource(token);
			PopularDeviantart popularResults = resource.getPopular();
			
			if (popularResults!=null) {
				request.setAttribute("publicacionesPopular", popularResults.getResults());
				request.getRequestDispatcher("/").forward(request, response);
			} else {
				log.warning("Intentando obtener placebo sin token");
				request.getRequestDispatcher("/views/error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/AuthController/Deviantart").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
