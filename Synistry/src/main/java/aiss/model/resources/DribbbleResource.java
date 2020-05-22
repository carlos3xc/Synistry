package aiss.model.resources;

import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.deviantart.PopularDeviantart;
import aiss.model.dribbble.Shot;

public class DribbbleResource {

	private static final Logger log = Logger.getLogger(DribbbleResource.class.getName());
	private final String access_token;
	private final String uri_base = "https://api.dribbble.com/v2/";

	public DribbbleResource(String access_token) {
		this.access_token = access_token;
	}

	public Shot getShots() {
		String uri = uri_base + "user/shots";
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(access_token);
		cr.setChallengeResponse(chr);
		Shot shots = null;
		
		try {
			shots = cr.get(Shot.class);
			return shots;
		} catch (ResourceException re) {
			log.warning("Error accediendo a populares: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}

	}
}
