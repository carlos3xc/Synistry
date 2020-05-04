package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.deviantart.Placebo;
import aiss.model.resources.placeboResource;


public class placeboController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(placeboController.class.getName());
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		log.log(Level.FINE, "Testeando el placebo del token");
		String token = (String) request.getSession().getAttribute("Deviantart-token");
		if (token!=null && !"".equals(token)) {
			placeboResource resource = new placeboResource(token);
			Placebo placeboResult = resource.getPlacebo();
			
			if (placeboResult!=null) {
				request.setAttribute("resultado", placeboResult.getStatus());
				request.getRequestDispatcher("/views/success.jsp").forward(request, response);
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
