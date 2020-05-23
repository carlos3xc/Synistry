package aiss.api.resources;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import aiss.api.model.Idea;
import aiss.api.model.repository.SynistryRepository;
import aiss.api.model.repository.SynistryRepositoryClass;

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


}
