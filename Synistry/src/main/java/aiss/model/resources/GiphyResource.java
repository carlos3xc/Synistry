package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.util.log.Log;
import org.restlet.resource.ClientResource;

import aiss.model.giphy.Example;
import aiss.model.giphy.Search.GiphySearch;


public class GiphyResource {

	private static final String GIPHY_API_KEY="5EBzbT382XIvTh9b2qRxnjmrfwvl6eIq";
	private static final Logger Log = Logger.getLogger(GiphyResource.class.getName());
	
	
	public  GiphySearch getSearch(String query) throws UnsupportedEncodingException {
		
	
		
		String uri ="https://api.giphy.com/v1/gifs/search?api_key=" + GIPHY_API_KEY +"&q=" +

				URLEncoder.encode(query , "UTF-8") + "&limit=8&offset=&rating=G&lang=es" ;

		
		Log.log(Level.FINE , "Giphy URI : "+ uri);
		
		ClientResource cr = new ClientResource(uri);
		GiphySearch giphySearch = cr.get(GiphySearch.class);
		
		return giphySearch;
	}

	
	
	
	public  Example getCategories() throws UnsupportedEncodingException {
		
	
		
		String uri ="https://api.giphy.com/v1/gifs/categories?api_key=" + GIPHY_API_KEY  ;
		
		Log.log(Level.FINE , "Giphy URI : "+ uri);
		
		ClientResource cr1 = new ClientResource(uri);
		Example giphycategories = cr1.get(Example.class);
		
		return giphycategories;
	}

}
