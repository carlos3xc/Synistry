package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.deviantart.Placebo;
import aiss.model.resources.placeboResource;


public class placeboController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(placeboController.class.getName());
	
	public placeboController() {
		super();
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		RequestDispatcher rd = null;
		log.log(Level.FINE, "Testeando el placebo del token");
		placeboResource placebo = new placeboResource();
		Placebo placeboResult = placebo.getPlacebo();
		
		if (placeboResult!=null) {
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("resultado", placeboResult);
		}else {
			log.log(Level.SEVERE, "Amadeus Object" + placeboResult);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
