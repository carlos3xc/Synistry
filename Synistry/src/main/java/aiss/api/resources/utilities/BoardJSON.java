package aiss.api.resources.utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import aiss.api.model.Board;
import aiss.api.model.BoardType;

@JsonInclude(Include.NON_NULL)
public class BoardJSON {
	
	private String author;
	private String authorURL;
	private String title;
	private String text;
	private String password;
	private String type;
	
	
	public BoardJSON() {
		super();
	}

	public BoardJSON(String author, String authorURL, String title, String text, String password, String type) {
		super();
		this.author = author;
		this.authorURL = authorURL;
		this.title = title;
		this.text = text;
		this.password = password;
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorURL() {
		return authorURL;
	}

	public void setAuthorURL(String authorURL) {
		this.authorURL = authorURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Board getBoard() {
		BoardType boardType;
		switch (getType().toLowerCase()) {
		case "public":
			boardType = BoardType.PUBLIC;
			break;
		case "protected":
			boardType = BoardType.PROTECTED;
			break;
		case "private":
			boardType = BoardType.PRIVATE;
			break;
		default:
			boardType = null;
		}
		String passwordHash = new Integer(password.hashCode()).toString();
		return new Board(getAuthor(), getAuthorURL(), getTitle(), getText(), passwordHash, boardType);
	}
	
}
