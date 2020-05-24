package aiss.model.repository;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.deviantart.Comments;
import aiss.model.deviantart.Deviation;
import aiss.model.deviantart.PopularDeviantart;
import aiss.model.resources.DeviantartResource;

public class DeviantartTest {
	String token = "7780108d5141f39d32ed795eb212588195b2586c36048689cf"; // necesario actualizar al realizar la prueba

	@Test
	public void testGetPublicacion() {
		String id = "F332C35E-D5E5-C493-813C-18A1FB99746C";
		
		DeviantartResource r = new DeviantartResource(token);
		
		Deviation Result = r.getPublicacion(id);
		
		// Comprobamos que la publicacion no devuelve null
		assertNotNull("La búsqueda devolvió null", Result);
		System.out.println("Búsqueda getdeviation() con éxito ya que el token "+token+" es correcto");
		
		
	}
	@Test
	public void testGetBusqueda() throws UnsupportedEncodingException {
		String query = "hola";
		DeviantartResource deviationResource = new DeviantartResource(token);
		PopularDeviantart searchResults = deviationResource.getSearch(query);
		
		// Comprobamos que la publicacion no devuelve null
		assertNotNull("La búsqueda devolvió null", searchResults);
		System.out.println("Búsqueda testGetBusqueda() con éxito ya que el token "+token+" es correcto");
		
		
	}
	@Test
	public void testGetPopulares() throws UnsupportedEncodingException {
		DeviantartResource resource = new DeviantartResource(token);
		PopularDeviantart popularResults = resource.getPopular();
		
		// Comprobamos que la publicacion no devuelve null
		assertNotNull("La búsqueda devolvió null", popularResults);
		System.out.println("Búsqueda testGetPopulares() con éxito ya que el token "+token+" es correcto");
		
		
	}
	@Test
	public void testGetComments() throws UnsupportedEncodingException {
		String id = "F332C35E-D5E5-C493-813C-18A1FB99746C";
		DeviantartResource deviationResource = new DeviantartResource(token);
		Comments comentarios = deviationResource.getComments(id);
		// Comprobamos que la publicacion no devuelve null
		assertNotNull("La búsqueda devolvió null", comentarios);
		System.out.println("Búsqueda testGetComments() con éxito ya que el token "+token+" es correcto");
		
		
	}
	@Test
public void addCommentToAnyPublication() throws IOException{
		DeviantartResource resource = new DeviantartResource(token);
		// Creamos el token y obtenemos el id de la primera lista. Cogemos como venueId uno cualquiera.
		Integer max = Math.max(0, resource.getPopular().getResults().size()-1);
		String Id = resource.getPopular().getResults().get(max).getDeviationid(); 
		
		
	
		// Añadimos a la primera lista del usuario el lugar dado
		boolean c = resource.createComment(Id, "cometario cualquiera");
		
		// Comprobamos que la búsqueda no devuelve null 
		assertNotNull("La creación de la lista no devolvió null", c);
		System.out.println("addCommentToAnyPublication() completado con éxito");
	}

}
