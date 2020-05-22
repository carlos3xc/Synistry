package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jetty.util.log.Log;
import org.restlet.resource.ClientResource;

import aiss.model.giphy.Example;
import aiss.model.giphy.Search.GiphySearch;
import aiss.model.museum.Collections;


public class MuseumResource {

	private static final String MUSEUM_API_KEY="NTLLx65p";
	private static final Logger Log = Logger.getLogger(MuseumResource.class.getName());
	
	
	public  Collections getSearch(String query) throws UnsupportedEncodingException {
		
	
		
		String uri ="https://www.rijksmuseum.nl/api/nl/collection?key=" + MUSEUM_API_KEY +"&q=" +

				URLEncoder.encode(query , "UTF-8");

		
		Log.log(Level.FINE , "Museum URI : "+ uri);
		
		ClientResource cr = new ClientResource(uri);
		Collections collections = cr.get(Collections.class);
		
		return collections;
	}

}
