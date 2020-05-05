package aiss.model.resources;

import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


import aiss.model.deviantart.PopularDeviantart;

public class DeviantartResource {
	private static final Logger log = Logger.getLogger(DeviantartResource.class.getName());
	
	 private final String access_token;
	 
	public DeviantartResource(String access_token) {
		this.access_token = access_token;
	}
	
	public PopularDeviantart getPopular() {
		String uri = "https://www.deviantart.com/api/v1/oauth2/browse/popular";
		ClientResource cr = new ClientResource(uri);
		 ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	    PopularDeviantart popular = null;
	     try {
	    	 popular = cr.get(PopularDeviantart.class);
	    	 return popular;
		} catch (ResourceException re) {
			log.warning("Error accediendo a populares: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
		
		
	}
}
