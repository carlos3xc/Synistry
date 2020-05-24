package aiss.api.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonSerialize(include = Inclusion.NON_NULL)
public class Board {
	private String id;
	private String author;
	private String authorURL;
	private String title;
	private String text;
	private String passwordHash;
	BoardType type;
	private Set<Idea> ideas;
	
	public Board() {
		super();
	}

	public Board(String id, String author, String authorURL, String title,String text, String passwordHash, BoardType type, Set<Idea> ideas) {
		super();
		this.id = id;
		this.author = author;
		this.authorURL = authorURL;
		this.title = title;
		this.text = text;
		this.passwordHash = passwordHash;
		this.type = type;
		this.ideas = ideas;
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
	
	public void setIdeas(Set<Idea> ideas) {	this.ideas = ideas;	}
	
	public Boolean addIdea(Idea idea) {
		return getIdeas().add(idea);
	}
	
	public Boolean removeIdea(Idea idea) {
		return getIdeas().remove(idea);
	}
	
	public Board filterFields(Set<String> includedFields) {
		Board res;
		if(includedFields==null||includedFields.isEmpty()) {
			res = new Board(getId(), getAuthor(), getAuthorURL(), getTitle(), getText(), null, getType(), getIdeas());
		}else {
			res = new Board();
			if(includedFields.contains("id")) {
				res.setId(getId());
			}
			if(includedFields.contains("author")) {
				res.setAuthor(getAuthor());
			}
			if(includedFields.contains("authorURL")) {
				res.setAuthorURL(getAuthorURL());
			}
			if(includedFields.contains("title")) {
				res.setTitle(getTitle());
			}
			if(includedFields.contains("text")) {
				res.setText(getText());
			}
			if(includedFields.contains("type")) {
				res.setType(getType());
			}
			if(includedFields.contains("ideas")) {
				res.setIdeas(getIdeas());
			}
		}
		
		return res;
	}
	
	/*Return a copy of the board with no passwordHash and null ideas*/
	public Board secureBoard() {
		Board res = new Board(getId(), getAuthor(), getAuthorURL(), getTitle(), getText(), null, getType(), null);
		return res;
	}
	
}
