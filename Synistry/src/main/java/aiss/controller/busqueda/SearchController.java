package aiss.controller.busqueda;

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

public class SearchController extends HttpServlet {

	
	 private static final long serialVersionUID= 1L;
	 
	 private static final Logger Log = Logger.getLogger(SearchController.class.getName());
	 
	 public SearchController() {
		 super();
	 }


protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{
	
	String query = request.getParameter("query");
	RequestDispatcher rd = null;
	
	Log.log(Level.FINE , "Searching gifs of =" + query);
	GiphyResource gifs = new GiphyResource();
	GiphySearch gifsResult = gifs.getSearch(query);
	
	
	if(gifsResult != null) {
		rd=request.getRequestDispatcher("/views/Search.jsp");
		request.setAttribute("resultadosGiphy", gifsResult.getData());
		
	} else {
		Log.log(Level.SEVERE , "eeee" + gifsResult);
		rd= request.getRequestDispatcher("/error.jsp");
		
	}
	rd.forward(request, response);
}


protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{
	    
	doGet(request , response);

}

}

