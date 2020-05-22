package aiss.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.ValidationException;

import org.eclipse.jetty.util.security.Constraint;

public class Topic {
	private String id;
	private String name;
	private String description;
	private Set<Idea> ideas;
	
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ideas = new HashSet<Idea>();
	}
	
	public Topic(String name, String description) {
		this.id = name.toLowerCase().replaceAll("\\s+", "-").replaceAll("[^\\x20-\\x7e]", "");
		this.name = name;
		this.description = description;
		this.ideas = new HashSet<Idea>();
	}

	public String getId() {	return id;}
	
	public void setId(String name) {
		this.id = name.toLowerCase().replaceAll("\\s+", "-").replaceAll("[^\\x20-\\x7e]", "");
		}

	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getDescription() {return description;}
	
	public void setDescription(String description) {this.description = description;}
	
	public Set<Idea> getIdeas() {return ideas;}
	
	public void addIdea(Idea idea) {
		if(idea.getTopic()==null||idea.getTopic().equalsToTopic(this)) {
			idea.setTopic(new TopicReference(getId(),getName()));
			getIdeas().add(idea);
		} else {
			throw new ModelException("Topic.addIdea()-> Failed to add Idea("
					+ idea.getId()+", "+ "title: " + idea.getTitle()+","+ "topicID: "+idea.getTopic().getTopicId()
					+") to topicID" + getId());
		}
	}
	
	public void removeIdea(Idea idea) {
		if(idea.getTopic()!=null&&!idea.getTopic().equalsToTopic(this)) {
			idea.setTopic(null);
			getIdeas().remove(idea);
		} else {
			throw new ModelException("Topic.removeIdea()-> Failed to remove Idea("
				+ idea.getId()+", "+ "title: " + idea.getTitle()+","+ "topicID: "+idea.getTopic().getTopicId()
				+") from topicID: " + getId());
		}
	}
	
	
	
}
