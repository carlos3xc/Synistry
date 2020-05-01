package aiss.model.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.devianart.DevianartProfile;

	

public class DevianartProfileResource {
	private static final Logger log = Logger.getLogger(DevianartProfile.class.getName());
	public DevianartProfile getDevianartProfile() {
		String uri = "https://www.deviantart.com/api/v1/oauth2/user/whoami";
		log.log(Level.FINE, "PROFILE URI: " + uri);
		ClientResource cr = new ClientResource(uri);
		DevianartProfile devianartProfile = cr.get(DevianartProfile.class);
		return devianartProfile;}
}
