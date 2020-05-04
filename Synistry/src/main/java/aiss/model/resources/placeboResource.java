package aiss.model.resources;

import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


import aiss.model.deviantart.Placebo;

public class placeboResource {
	private static final Logger log = Logger.getLogger(placeboResource.class.getName());
	
	 private final String access_token;
	 
	public placeboResource(String access_token) {
		this.access_token = access_token;
	}
	
	public Placebo getPlacebo() {
		String uri = "https://www.deviantart.com/api/v1/oauth2/placebo";
		ClientResource cr = new ClientResource(uri);
		 ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	     Placebo placebo = null;
	     try {
	    	 placebo = cr.get(Placebo.class);
	    	 return placebo;
		} catch (ResourceException re) {
			log.warning("Error accediendo al placebo: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
		
		
	}
}
