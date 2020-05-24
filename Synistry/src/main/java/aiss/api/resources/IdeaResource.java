package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.validator.routines.UrlValidator;
import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Comment;
import aiss.api.model.Idea;
import aiss.api.model.repository.SynistryRepository;
import aiss.api.model.repository.SynistryRepositoryClass;
import aiss.api.resources.utilities.IdeaJSON;

@Path("/ideas")
public class IdeaResource {
	
	public static IdeaResource _instance=null;
	SynistryRepository repository;
	
	private IdeaResource() {
		repository=SynistryRepositoryClass.getInstance();
	}
	
	public static IdeaResource getInstance() {
		if(_instance==null) {
			_instance = new IdeaResource();
		}
		return _instance;
	}
	
	@GET
	@Produces("application/json")	
	public Collection<Idea> getAll(){
		return repository.getAllIdeas();
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")	
	public Idea getIdea(@PathParam("id") String ideaId){
		
		Idea idea = repository.getIdea(ideaId);
		if(idea==null) {
			throw new NotFoundException("The idea with id="+ ideaId +" was not found");	
		}
		
		return idea;
	}
	
	@GET
	@Path("/{id}/comments")
	@Produces("application/json")	
	public Collection<Comment> getCommentsFromIdea(@PathParam("id") String ideaId){
		Idea idea = repository.getIdea(ideaId);
		if(idea==null) {
			throw new NotFoundException("The idea with id="+ ideaId +" was not found");	
		}
		return idea.getComments();
	}
	
	@POST
	@Path("/{id}/comment")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createComment(@Context UriInfo uriInfo, @PathParam("id") String ideaId, Comment comment){
		validateComment(comment);
		
		Idea idea = repository.getIdea(ideaId);
		if(idea==null) {
			throw new NotFoundException(
					"The idea with id="+ ideaId +" was not found, so the comment could not be created.");	
		}
		repository.createComment(comment, ideaId);
		//Build the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getIdea");
		URI uri = ub.build(idea.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(idea);
		return resp.build();
	}
	
	private void validateComment(Comment comment) {
		if(comment.getText()==null||comment.getText().trim().isEmpty()) {
			throw new BadRequestException("The text in a comment cannot be empty");
		}
	    String[] schemes = {"http","https"};
	    UrlValidator urlValidator = new UrlValidator(schemes);
		if(comment.getAuthorURL()!=null
				&&(comment.getAuthorURL().isEmpty()||!urlValidator.isValid(comment.getAuthorURL()))) {
			throw new BadRequestException("The authorURL, if provided, must be a valid URL");
		}
		if(comment.getExternalLink()!=null
				&&(comment.getExternalLink().isEmpty()||!urlValidator.isValid(comment.getExternalLink()))) {
			throw new BadRequestException("The externalLink, if provided, must be a valid URL");
		}
		if(comment.getAuthor()!=null&&comment.getAuthor().isEmpty()) {
			throw new BadRequestException("The author, if provided, must not be a blank");
		}
	}
	
	@GET
	@Path("/search")
	@Produces("application/json")	
	public Collection<Idea> searchIdeasByTitleOrText(@QueryParam("q") String query){
		return repository.searchIdeasByTitleOrText(query);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createIdea(@Context UriInfo uriInfo, IdeaJSON ideaJSON) {
		Idea idea = ideaJSON.toIdea();
		validateIdea(idea);
		Idea savedIdea = repository.createIdea(idea);
		
		//Build the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getIdea");
		URI uri = ub.build(savedIdea.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(savedIdea);
		return resp.build();
		
	}
	
	private void validateIdea(Idea idea) {
		if(idea.getTitle()== null||idea.getTitle().isEmpty()
				||idea.getImageURL()==null||idea.getImageURL().isEmpty()
				||idea.getLink()==null||idea.getLink().isEmpty()) {
			throw new BadRequestException("The title, imageURL or link must not be null or empty.");
		}
	    String[] schemes = {"http","https"};
	    UrlValidator urlValidator = new UrlValidator(schemes);
	    if(!urlValidator.isValid(idea.getImageURL())) {
	    	throw new BadRequestException("The imageURL is not valid");
	    }
	    if(idea.getLink()!=null&&!idea.getLink().isEmpty()&&!urlValidator.isValid(idea.getLink())) {
	    	throw new BadRequestException("The link provided is not valid");
	    }
	}
	
	


}
