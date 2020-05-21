package aiss.controller.comentario;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.deviantart.Comments;
import aiss.model.deviantart.PopularDeviantart;
import aiss.model.resources.DeviantartResource;


public class CommentController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(CommentController.class.getName());
	

	
	 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        String id = req.getParameter("deviationId");
	        String body = req.getParameter("body");
	        String accessToken = (String) req.getSession().getAttribute("Deviantart-token");
	        if (id != null && !id.trim().isEmpty() && body != null && !body.trim().isEmpty()) {
	           
	            log.info(accessToken);
	            if (accessToken != null && !"".equals(accessToken)) {
	                DeviantartResource spResource = new DeviantartResource(accessToken);
	                spResource.createComment(id, body);
	                req.getRequestDispatcher("/oauth2callback/PublicacionController").forward(req, resp);
	            } else {
	                log.info("Trying to access Spotify without an access token, redirecting to OAuth servlet");
	                
	                req.getRequestDispatcher("/AuthController/Deviantart").forward(req, resp);
	            }
	        } else {
	            log.info("Controller invoked without parameters, redirecting to view");
	            req.getRequestDispatcher("/views/publicacion.jsp").forward(req, resp);
	        }
	        

	        
	    }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
