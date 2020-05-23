package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.IdeaResource;

public class SynistryApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public SynistryApplication() {
		singletons.add(IdeaResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return this.classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
	
	

}
