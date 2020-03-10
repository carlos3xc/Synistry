package aiss;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(HomeServlet.class.getName());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		// Sample log
		log.log(Level.FINE, "Processing GET request");
		 
		request.getRequestDispatcher("/views/homePage.jsp").forward(request, response);
	}
}
