package aiss.api.resources.utilities;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import aiss.api.model.Board;

@JsonInclude(Include.NON_NULL)
public class PasswordBoardJSON {
	private String password;
	private BoardJSON boardJSON;

	public PasswordBoardJSON() {
		super();
	}

	public PasswordBoardJSON(String password, BoardJSON boardJSON) {
		super();
		this.password = password;
		this.boardJSON = boardJSON;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("board")
	public BoardJSON getBoardJSON() {
		return boardJSON;
	}

	@JsonProperty("board")
	public void setBoardJSON(BoardJSON boardJSON) {
		this.boardJSON = boardJSON;
	}
	
	public Board toBoard(String boardId) {
		Board res = getBoardJSON().getBoard();
		res.setId(boardId);
		return res;
	}
	
	
	
	
	

}
