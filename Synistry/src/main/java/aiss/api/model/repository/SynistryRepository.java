package aiss.api.model.repository;

import java.util.Collection;

import aiss.api.model.Board;
import aiss.api.model.BoardType;
import aiss.api.model.Comment;
import aiss.api.model.Idea;
import aiss.api.model.Topic;

public interface SynistryRepository {
	
	// ----- Ideas ------
	public Idea createIdea(Idea idea);
	public Idea getIdea(String IdeaId);
	public Collection<Idea> getAllIdeas();
	public Collection<Idea> searchIdeasByTitleOrText(String query);
	//public void deleteIdea(String ideaId);
	
	// ----- Comments ------
	public void createComment(Comment comment, String ideaId);
	public Collection<Comment> getAllCommentsFromIdea(String ideaId);
	
	// ----- Topic ------
	public Topic getTopic(String topicId);
	public Collection<Idea> getAllIdeasFromTopic(String topicId);
	public Collection<Idea> searchIdeasByTitleOrTextAndTopic(String query, String topicId);
	
	// ----- Boards ------
	public Board createBoard(Board board);
	public Board getBoard(String boardId);
	public Board getPublicBoard(String boardId);
	public Board getPrivateBoard(String boardId, String password);
	public void updateBoard(Board board, String password);
	public void deletePrivateBoard(String boardId, String password);
	public void updateBoardType(String boardId, String password, BoardType boardType);
	public void updateBoardPassword(String boardId, String password, String newPassword);
	public Collection<Board> getAllBoards();
	public Collection<Board> getAllVisibleBoards();
	public void addIdeaToPublicBoard(Idea idea, String boardId);
	public void addIdeaToProtectedOrPrivateBoard(Idea idea, String boardId, String password);
	public void removeIdeaFromBoard(String ideaId, String boardId, String password);
	

}
