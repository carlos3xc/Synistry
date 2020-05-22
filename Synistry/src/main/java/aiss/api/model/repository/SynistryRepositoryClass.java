package aiss.api.model.repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aiss.api.model.Board;
import aiss.api.model.BoardType;
import aiss.api.model.Comment;
import aiss.api.model.Idea;
import aiss.api.model.Topic;
import aiss.api.model.utils.AlphanumericSequence;

public class SynistryRepositoryClass implements SynistryRepository{
	
	Map<String, Idea> ideasMap;
	Map<String, Comment> commentsMap;
	Map<String, Topic> topicsMap;
	Map<String, Board> boardsMap;
	
	private static SynistryRepositoryClass instance=null;
	private static AlphanumericSequence ideasSequence = new AlphanumericSequence(4);
	private static AlphanumericSequence commentsSequence = new AlphanumericSequence(5);
	private static AlphanumericSequence boardsSequence = new AlphanumericSequence(3);

	@Override
	public void createIdea(Idea idea) {
		idea.setId(ideasSequence.next());
		Topic topic = getTopic(idea.getTopic().getTopicId());
		topic.addIdea(idea);
		ideasMap.put(idea.getId(), idea);
	}

	@Override
	public Idea getIdea(String IdeaId) {
		return ideasMap.get(IdeaId);
	}

	@Override
	public Collection<Idea> getAllIdeas() {
		return ideasMap.values();
	}

	@Override
	public Collection<Idea> searchIdeasByTitleOrText(String query) {
		Collection<Idea> res = new HashSet<Idea>();
		
		String[] parsedQuery = query.toLowerCase().replaceAll("[,.-;:()/\"]", " ").split("(\\s+)");
		Set<String> queryWordSet = new HashSet<String>(Arrays.asList(parsedQuery));
		
		for(Idea idea:getAllIdeas()) {
			if(anyWordIsContainedIn(idea.getTitle(),queryWordSet)
					||anyWordIsContainedIn(idea.getText(),queryWordSet)
					||anyWordIsContainedIn(idea.getTopic().getTopicName(),queryWordSet)
					||anyWordIsContainedIn(idea.getLink(),queryWordSet)) {
				res.add(idea);
			}
		}
		return res;
	}
	
	private static Boolean anyWordIsContainedIn(String string, Set<String> words) {
		Boolean res = false;
		for(String word:words) {
			res=res||string.contains(word);
			if(res==true) {break;}
		}
		return res;
	}

	@Override
	public void createComment(Comment comment, String ideaId) {
		Idea idea = ideasMap.get(ideaId);
		idea.addComment(comment);
	}

	@Override
	public Collection<Comment> getAllCommentsFromIdea(String ideaId) {
		Idea idea = ideasMap.get(ideaId);
		return idea.getComments();
	}

	@Override
	public Topic getTopic(String topicId) {
		return topicsMap.get(topicId);
	}

	@Override
	public Collection<Idea> getAllIdeasFromTopic(String topicId) {
		Topic topic = topicsMap.get(topicId);
		return null;
	}

	@Override
	public Collection<Idea> searchIdeasByTitleOrTextAndTopic(String query, String topicId) {
		Collection<Idea> res = new HashSet<Idea>();
		Topic topic = topicsMap.get(topicId);
		
		String[] parsedQuery = query.toLowerCase().replaceAll("[,.-;:()/\"]", " ").split("(\\s+)");
		Set<String> queryWordSet = new HashSet<String>(Arrays.asList(parsedQuery));
		
		for(Idea idea:topic.getIdeas()) {
			if(anyWordIsContainedIn(idea.getTitle(),queryWordSet)
					||anyWordIsContainedIn(idea.getText(),queryWordSet)
					||anyWordIsContainedIn(idea.getTopic().getTopicName(),queryWordSet)
					||anyWordIsContainedIn(idea.getLink(),queryWordSet)) {
				res.add(idea);
			}
		}
		return res;
	}

	@Override
	public Board getBoard(String boardId) {
		return boardsMap.get(boardId);
	}

	@Override
	public Board getPublicBoard(String boardId) {
		Board res = null;
		if(!getBoard(boardId).getType().equals(BoardType.PRIVATE)) {
			res = getBoard(boardId);
		}
		return res;
	}

	@Override
	public Board getPrivateBoard(String boardId, String password) {
		Board res = null;
		Board board = getBoard(boardId);
		String passwordHash = new Integer(password.hashCode()).toString();
		if(board.getType().equals(BoardType.PRIVATE)
				&&board.getPasswordHash().equals(passwordHash)) {
			res = getBoard(boardId);
		}
		return res;
	}

	@Override
	public void updatePrivateBoard(Board board, String password) {
		Board previousBoard = getBoard(board.getId());
		String passwordHash = new Integer(password.hashCode()).toString();
		if(previousBoard.getPasswordHash().equals(passwordHash)) {
			boardsMap.put(board.getId(), board);
		}else {
		}
		
	}

	@Override
	public void updateBoardType(String boardId, String password, BoardType boardType) {
		Board board = getBoard(boardId);
		String passwordHash = new Integer(password.hashCode()).toString();
		if(board.getPasswordHash().equals(passwordHash)) {
			board.setType(boardType);
		}else {
		}
	}

	@Override
	public void updateBoardPassword(String boardId, String password, String newPassword) {
		Board board = getBoard(boardId);
		String passwordHash = new Integer(password.hashCode()).toString();
		String newPasswordHash = new Integer(newPassword.hashCode()).toString();
		if(board.getPasswordHash().equals(passwordHash)) {
			board.setPasswordHash(newPasswordHash);
		}else {
		}
	}

	@Override
	public Collection<Board> getAllBoards() {
		return boardsMap.values();
	}

	@Override
	public Collection<Board> getAllVisibleBoards() {
		Collection<Board> res = new HashSet<Board>();
		
		for(Board b: getAllBoards()) {
			if(b.getType().equals(BoardType.PUBLIC)||b.getType().equals(BoardType.PROTECTED)) {
				res.add(b);
			}
		}
		return res;
	}

	@Override
	public void addIdeaToPublicBoard(Idea idea, String boardId) {
		Board board = getBoard(boardId);
		if(board.getType().equals(BoardType.PUBLIC)) {
			board.addIdea(idea);
		}
	}

	@Override
	public void addIdeaToProtectedOrPrivateBoard(Idea idea, String boardId, String password) {
		Board board = getBoard(boardId);
		String passwordHash = new Integer(password.hashCode()).toString();
		if(board.getPasswordHash().equals(passwordHash)&&(board.getType().equals(BoardType.PROTECTED)
				||board.getType().equals(BoardType.PRIVATE))) {
			board.addIdea(idea);
		}
	}

	@Override
	public void removeIdeaFromBoard(String ideaId, String boardId, String password) {
		Board board = getBoard(boardId);
		String passwordHash = new Integer(password.hashCode()).toString();
		Idea idea = getIdea(ideaId);
		if(board.getPasswordHash().equals(passwordHash)) {
			board.removeIdea(idea);
		}
	}

}
