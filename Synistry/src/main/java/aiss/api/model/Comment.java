package aiss.api.model;

import java.util.Date;

public class Comment {
	String id;
	String author;
	String authorURL;
	String text;
	String externalLink;
	Date date;
	
	public Comment(String id, String author, String authorURL, String text, String externalLink, Date date) {
		super();
		this.id = id;
		this.author = author;
		this.authorURL = authorURL;
		this.text = text;
		this.externalLink = externalLink;
		this.date = date;
	}

	public Comment(String author, String authorURL, String text, String externalLink, Date date) {
		super();
		this.author = author;
		this.authorURL = authorURL;
		this.text = text;
		this.externalLink = externalLink;
		this.date = date;
	}

	public String getId() {return id;}
	
	public void setId(String id) {this.id = id;}

	public String getAuthor() {return author;}
	
	public void setAuthor(String author) {this.author = author;}
	
	public String getAuthorURL() {return authorURL;}
	
	public void setAuthorURL(String authorURL) {this.authorURL = authorURL;}
	
	public String getText() {return text;}
	
	public void setText(String text) {this.text = text;}
	
	public String getExternalLink() {return externalLink;}
	
	public void setExternalLink(String externalLink) {this.externalLink = externalLink;	}

	public Date getDate() {
		return date;
	}
	
}
