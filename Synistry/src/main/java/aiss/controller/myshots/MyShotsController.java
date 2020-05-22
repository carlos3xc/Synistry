package aiss.controller.myshots;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.deviantart.Comments;
import aiss.model.deviantart.Deviation;
import aiss.model.dribbble.Shot;
import aiss.model.resources.DeviantartResource;
import aiss.model.resources.DribbbleResource;


public class MyShotsController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(MyShotsController.class.getName());
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		log.log(Level.FINE, "Accediendo a populares");
		String id = request.getParameter("deviationId");
		String token = (String) request.getSession().getAttribute("Dribbble-token");
	
		if (token!=null && !"".equals(token)) {
			DribbbleResource dribbbleResource = new DribbbleResource(token);
			Shot shots = dribbbleResource.getShots();
			
			
			if (shots!=null ) {
				request.setAttribute("shots", shots);
				
				request.getRequestDispatcher("/views/shots.jsp").forward(request, response);
			} else {
				log.warning("Intentando obtener busqueda sin token");
				request.getRequestDispatcher("/views/error.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/AuthController/Dribbble").forward(request, response);
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
