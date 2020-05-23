package aiss.model.resources;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Form;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import aiss.model.deviantart.Comments;
import aiss.model.deviantart.Deviation;
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
	
	
	public PopularDeviantart getSearch(String query) throws UnsupportedEncodingException {
		String q = URLEncoder.encode(query, "UTF-8");
		String uri = "https://www.deviantart.com/api/v1/oauth2/browse/popular?q="+ q + "&timerange=24hr&mature_content=true";
		ClientResource cr = new ClientResource(uri);
		 ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	    PopularDeviantart popular = null;
	     try {
	    	 popular = cr.get(PopularDeviantart.class);
	    	 return popular;
		} catch (ResourceException re) {
			log.warning("Error accediendo a busqueda: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
		
		
	}
	public Deviation getPublicacion(String id) {
		String uri = "https://www.deviantart.com/api/v1/oauth2/deviation/" +id;
		ClientResource cr = new ClientResource(uri);
		 ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	    Deviation publicacion = null;
	     try {
	    	 publicacion = cr.get(Deviation.class);
	    	 return publicacion;
		} catch (ResourceException re) {
			log.warning("Error accediendo a busqueda: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
		
		
	}

	public Comments getComments(String id) {
		String uri = "https://www.deviantart.com/api/v1/oauth2/comments/deviation/" +id;
		ClientResource cr = new ClientResource(uri);
		 ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	    Comments publicacion = null;
	     try {
	    	 publicacion = cr.get(Comments.class);
	    	 return publicacion;
		} catch (ResourceException re) {
			log.warning("Error accediendo a commentarios: " + cr.getResponse().getStatus());
			log.warning(uri);
			return null;
		}
		
		
	}
	
	
	public boolean createComment(String id, String body) throws IOException {
	       
	            String PostURL ="https://www.deviantart.com/api/v1/oauth2/comments/post/deviation/"+id;
	            ClientResource cr = new ClientResource(PostURL);
	            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	            chr.setRawValue(access_token);
	            cr.setChallengeResponse(chr);
	            log.info("Creating new comment 	with id '" + id + "', body '" + body+"," );
	         
	            Form form = new Form();
	            form.add("body",body);
	          
	            try {
	                cr.post(form);
	                return true;

	            } catch (ResourceException re) {
	                log.warning("Error when creating a comment: " + cr.getResponse().getStatus());
	                log.warning(PostURL);
	                throw re;
	            }
	       
      } 
}
