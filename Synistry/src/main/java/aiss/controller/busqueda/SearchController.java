package aiss.controller.busqueda;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.deviantart.PopularDeviantart;
import aiss.model.giphy.Search.GiphySearch;
import aiss.model.museum.Collections;
import aiss.model.resources.DeviantartResource;
import aiss.model.resources.GiphyResource;
import aiss.model.resources.MuseumResource;
public class SearchController extends HttpServlet {

	
	 private static final long serialVersionUID= 1L;
	 
	 private static final Logger log = Logger.getLogger(SearchController.class.getName());
	 
	 public SearchController() {
		 super();
	 }


protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{
	
	String query = request.getParameter("query");
	RequestDispatcher rd = null;
	
	log.log(Level.FINE , "Searching gifs of =" + query);
	GiphyResource gifs = new GiphyResource();
	GiphySearch gifsResult = gifs.getSearch(query);
	if(gifsResult != null) {
		rd=request.getRequestDispatcher("/views/Search.jsp");
		request.setAttribute("resultadosGiphy", gifsResult.getData());
		
	} else {
		log.log(Level.SEVERE , "eeee" + gifsResult);
		rd= request.getRequestDispatcher("/error.jsp");
		
	}

	
	
	log.log(Level.FINE , "Searching museum of =" + query);
	MuseumResource res = new MuseumResource();
	Collections collections = res.getSearch(query);
	if(collections != null) {
		request.getRequestDispatcher("/views/Search.jsp");
		request.setAttribute("resultadosMuseum", collections.getArtObjects());
		
	} else {
		log.log(Level.SEVERE , "eeee" + gifsResult);
		request.getRequestDispatcher("/error.jsp");
		
	}
	
	
	

	log.log(Level.FINE, "Accediendo a populares");
	String token = (String) request.getSession().getAttribute("Deviantart-token");
	if (token!=null && !"".equals(token)) {
		DeviantartResource deviationResource = new DeviantartResource(token);
		PopularDeviantart searchResults = deviationResource.getSearch(query);
		
		if (searchResults!=null) {
			request.setAttribute("deviationResults", searchResults.getResults());
			request.getRequestDispatcher("/views/Search.jsp").forward(request, response);
		} else {
			log.warning("Intentando obtener busqueda sin token");
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	} else {
		request.getRequestDispatcher("/AuthController/Deviantart").forward(request, response);
	}
	
	rd.forward(request, response);
	
	
}


protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{
	    
	doGet(request , response);

}

}

