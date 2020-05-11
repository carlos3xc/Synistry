package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.restlet.resource.ClientResource;

import aiss.model.giphy.GiphySearch;

public class GiphyResource {

	private static final String GIPHY_API_KEY="5EBzbT382XIvTh9b2qRxnjmrfwvl6eIq";
	private static final Logger Log = Logger.getLogger(GiphyResource.class.getName());
	
	
	public  GiphySearch getSearch(String query) throws UnsupportedEncodingException {
		
	
		
		String uri ="https://api.giphy.com/v1/gifs/search?api_key=" + GIPHY_API_KEY +"&q=" +
				URLEncoder.encode(query , "UTF-8") + "&limit=6&offset=&rating=G&lang=es" ;
		
		Log.log(Level.FINE , "Giphy URI : "+ uri);
		
		ClientResource cr = new ClientResource(uri);
		GiphySearch giphySearch = cr.get(GiphySearch.class);
		
		return giphySearch;
	}
	
public  GiphySearch getCategories() throws UnsupportedEncodingException {
		
	
		
		String uri ="https://api.giphy.com/v1/gifs/categories?api_key=" + GIPHY_API_KEY  ;
		
		Log.log(Level.FINE , "Giphy URI : "+ uri);
		
		ClientResource cat = new ClientResource(uri);
		GiphySearch giphyCategories = cat.get(GiphySearch.class);
		
		return giphyCategories;
	}
}
