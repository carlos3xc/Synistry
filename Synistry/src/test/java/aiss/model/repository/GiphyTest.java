package aiss.model.repository;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.controller.publicacion.PublicacionController;
import aiss.model.deviantart.Deviation;
import aiss.model.giphy.Example;
import aiss.model.giphy.Search.GiphySearch;
import aiss.model.resources.DeviantartResource;
import aiss.model.resources.GiphyResource;

public class GiphyTest {

	@Test
	public void testGetBusquedaGiphy() throws UnsupportedEncodingException {
		String query = "hola";
		GiphyResource gifs = new GiphyResource();
		GiphySearch gifsResult = gifs.getSearch(query);
		
		// Comprobamos que la publicacion no devuelve null
		assertNotNull("La búsqueda devolvió null", gifsResult);
		System.out.println("Búsqueda getWikipediaInfoTest() con éxito");
		
		
	}
	
	public void testGetCategoriasGiphy() throws UnsupportedEncodingException {

		GiphyResource gifscat = new GiphyResource();
		Example CategoriesResult = gifscat.getCategories();
		
		
		// Comprobamos que la publicacion no devuelve null
		assertNotNull("La búsqueda devolvió null", CategoriesResult);
		System.out.println("Búsqueda getWikipediaInfoTest() con éxito");
		
		
	}

}
