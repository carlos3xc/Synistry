package aiss.model.resources;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.dribbble.Project;


public class DribbbleResource {

	private static final Logger log = Logger.getLogger(DribbbleResource.class.getName());
	private final String access_token;
	private final String uri = "https://api.dribbble.com/v2/";
	//private final String uri_upload = "https://www.googleapis.com/upload/drive/v2/files";

	public DribbbleResource(String access_token) {
		this.access_token = access_token;
	}
	
	 public Project getProject(String user) {
	        ClientResource cr = null;
	        Project project = null;
	        try {
	            cr = new ClientResource((uri + user + "/projects"));
	          
	            project = cr.get(Project.class);

	        } catch (ResourceException re) {
	            log.warning("Error when retrieving projects: " + cr.getResponse().getStatus());
	        }

	        return project;

	    }
}
