package aiss.model.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.deviantart.Placebo;

public class placeboResource {
	private static final Logger log = Logger.getLogger(placeboResource.class.getName());
	
	public Placebo getPlacebo() {
		String uri = "https://www.deviantart.com/api/v1/oauth2/placebo";
		ClientResource cr = new ClientResource(uri);
		log.log(Level.FINE, "Placebo URI" + uri);
		Placebo placebo = cr.get(Placebo.class);
		return placebo;
	}
}
