package aiss.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.ValidationException;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.eclipse.jetty.util.security.Constraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonSerialize(include = Inclusion.NON_NULL)
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
		if(idea.getTopicReference()==null||idea.getTopicReference().equalsToTopic(this)) {
			idea.setTopicReference(new TopicReference(getId(),getName()));
			getIdeas().add(idea);
		} else {
			throw new ModelException("Topic.addIdea()-> Failed to add Idea("
					+ idea.getId()+", "+ "title: " + idea.getTitle()+","+ "topicID: "+idea.getTopicReference().getTopicId()
					+") to topicID" + getId());
		}
	}
	
	public void removeIdea(Idea idea) {
		if(idea.getTopicReference()!=null&&!idea.getTopicReference().equalsToTopic(this)) {
			idea.setTopicReference(null);
			getIdeas().remove(idea);
		} else {
			throw new ModelException("Topic.removeIdea()-> Failed to remove Idea("
				+ idea.getId()+", "+ "title: " + idea.getTitle()+","+ "topicID: "+idea.getTopicReference().getTopicId()
				+") from topicID: " + getId());
		}
	}
	
	
	
}
