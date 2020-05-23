package aiss.model.repository;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.museum.Collections;
import aiss.model.resources.MuseumResource;

public class MuseumTest {

	@Test
	
	public void testGetMuseumSearch() throws UnsupportedEncodingException {

		String query = "hola";
		MuseumResource res = new MuseumResource();
		Collections collections = res.getSearch(query);
		
		// Comprobamos que la publicacion no devuelve null
		assertNotNull("La búsqueda devolvió null", collections);
		System.out.println("Búsqueda testGetMuseumSearch() con éxito");
		
		
	}

}
