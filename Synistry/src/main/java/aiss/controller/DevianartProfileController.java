package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.devianart.DevianartProfile;
import aiss.model.resources.DevianartProfileResource;

public class DevianartProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DevianartProfile.class.getName());
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.log(Level.FINE, "Buscando Perfil");
		
		RequestDispatcher rd =null;
		DevianartProfileResource devianartProfileResource = new DevianartProfileResource();
		DevianartProfile devianartProfileResult = devianartProfileResource.getDevianartProfile();	
		if (devianartProfileResult!=null) {
			String accessToken=(String) request.getSession().getAttribute("devianart-token");
			if (accessToken!=null && !"".equals(accessToken)) {
				rd = request.getRequestDispatcher("/homePage.jsp");
				request.setAttribute("devianartProfileImage",devianartProfileResult.getUsericon());
			}else {
				log.info("Trying to accesss to devianart without token redirecting to OauthServlet");
				request.getRequestDispatcher("/AuthController/devianart");
			}
			
		}else {
			log.log(Level.SEVERE, "Buscando Perfil");
			rd = request.getRequestDispatcher("/error.jsp");
			
			
			
			
			
			
			
		}
	
	
		
	
	
	
	
	
	
	
	}
	

	
}
