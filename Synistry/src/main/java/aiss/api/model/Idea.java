package aiss.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonSerialize(include = Inclusion.NON_NULL)
public class Idea {
	
	private String id;
	private String link;
	private String imageURL;
	private String title;
	private String text;
	private Date date;
	
	/*Relationships*/
	private TopicReference topicReference;
	private Set<Comment> comments;
	
	public Idea() {
		super();
	}

	public Idea(String id, String link, String imageURL, String title, String text, Date date, TopicReference topic,
			Set<Comment> comments) {
		super();
		this.id = id;
		this.link = link;
		this.imageURL = imageURL;
		this.title = title;
		this.text = text;
		this.date = date;
		this.topicReference = topic;
		this.comments = comments;
	}

	public Idea(String id, String link, String imageURL, String title, String text, Date date,
			String topicId, String topicName) {
		super();
		this.id = id;
		this.link = link;
		this.imageURL = imageURL;
		this.title = title;
		this.text = text;
		this.date = date;
		this.topicReference = new TopicReference(topicId,topicName);
		this.comments = new HashSet<Comment>();
	}
	
	public Idea(String id, String link, String imageURL, String title, String text, Date date, TopicReference topic) {
		super();
		this.id = id;
		this.link = link;
		this.imageURL = imageURL;
		this.title = title;
		this.text = text;
		this.date = date;
		this.topicReference = topic;
		this.comments = new HashSet<Comment>();
	}
	
	public Idea(String link, String imageURL, String title, String text, String topicId) {
		this.link = link;
		this.imageURL = imageURL;
		this.title = title;
		this.text = text;
		this.date = new Date();
		this.topicReference = new TopicReference(topicId,"");
		this.comments = new HashSet<Comment>();
	}

	public String getId() {return id;}

	public void setId(String id) {this.id = id;}

	public String getLink() {return link;}
	
	public void setLink(String link) {this.link = link;}
	
	public String getImageURL() {return imageURL;}
	
	public void setImageURL(String imageURL) {this.imageURL = imageURL;}
	
	public String getTitle() {return title;}
	
	public void setTitle(String title) {this.title = title;}
	
	public String getText() {return text;}
	
	public void setText(String text) {this.text = text;}
	
	public Date getDate() {return date;}
	
	public void setDate(Date date) {this.date = date;}
	
	public TopicReference getTopicReference() {return topicReference;}

	public void setTopicReference(TopicReference topic) {this.topicReference = topic;}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Comment> getComments() {return comments;}
	
	public Boolean addComment(Comment comment) {
		return getComments().add(comment);
	}
	
}
