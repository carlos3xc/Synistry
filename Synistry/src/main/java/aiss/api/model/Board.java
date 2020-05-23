package aiss.api.model;

import java.util.HashSet;
import java.util.Set;

public class Board {
	String id;
	String author;
	String authorURL;
	String title;
	String text;
	String passwordHash;
	BoardType type;
	private Set<Idea> ideas;
	
	public Board(String id, String author, String authorURL, String title,String text, String passwordHash, BoardType type) {
		super();
		this.id = id;
		this.author = author;
		this.authorURL = authorURL;
		this.title = title;
		this.text = text;
		this.passwordHash = passwordHash;
		this.type = type;
		this.ideas = new HashSet<Idea>();
	}
	
	public Board(String author, String authorURL, String title,String text, String passwordHash, BoardType type) {
		this.author = author;
		this.authorURL = authorURL;
		this.title = title;
		this.text = text;
		this.passwordHash = passwordHash;
		this.type = type;
		this.ideas = new HashSet<Idea>();
	}
	
	public static Board createBoard(String author, String authorURL, String title,
			String text, String password, BoardType type) {
		String passwordHash = new Integer(password.hashCode()).toString();
		return new Board(author, authorURL, title, text, passwordHash, type);
	}

	public String getId() {	return id;}

	public void setId(String id) {this.id = id;}

	public String getAuthor() {	return author;}
	
	public void setAuthor(String author) {	this.author = author;}
	
	public String getAuthorURL() {	return authorURL;	}
	
	public void setAuthorURL(String authorURL) {this.authorURL = authorURL;}
	
	
	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public String getText() {return text;}
	
	public void setText(String text) {	this.text = text;}
	
	public String getPasswordHash() {	return passwordHash;}
	
	public void setPasswordHash(String passwordHash) {	this.passwordHash = passwordHash;}
	
	public BoardType getType() {return type;}
	
	public void setType(BoardType type) {this.type = type;}
	
	public Set<Idea> getIdeas() {return ideas;}
	
	//public void setIdeas(Collection<Idea> ideas) {	this.ideas = ideas;	}
	
	public Boolean addIdea(Idea idea) {
		return getIdeas().add(idea);
	}
	
	public Boolean removeIdea(Idea idea) {
		return getIdeas().remove(idea);
	}
	
}
