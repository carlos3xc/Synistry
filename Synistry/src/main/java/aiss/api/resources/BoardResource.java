package aiss.api.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import aiss.api.model.Board;
import aiss.api.model.BoardType;
import aiss.api.model.repository.SynistryRepository;
import aiss.api.model.repository.SynistryRepositoryClass;
import aiss.api.resources.utilities.BoardJSON;

@Path("/boards")
public class BoardResource {
	
	public static BoardResource _instance=null;
	SynistryRepository repository;
	
	private BoardResource() {
		repository=SynistryRepositoryClass.getInstance();
	}
	
	public static BoardResource getInstance() {
		if(_instance==null) {
			_instance = new BoardResource();
		}
		return _instance;
	}
	
	@GET
	@Produces("application/json")	
	public Collection<Board> getAll(@QueryParam("fields") String fields){
		Set<String> includedFields;
		if(fields!=null&&!fields.isEmpty()) {
			String[] parsedFields = fields.toLowerCase().trim().split(",");
			includedFields = new HashSet<String>(Arrays.asList(parsedFields));
		}else {
			includedFields = new HashSet<String>();
		}
		
		Collection<Board> res = secureAllBoards(repository.getAllBoards(), includedFields);
		
		
		return res;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")	
	public Board getBoard(@QueryParam("fields") String fields, @PathParam("id") String boardId){
		Board res;
		Set<String> includedFields;
		if(fields!=null&&!fields.isEmpty()) {
			String[] parsedFields = fields.toLowerCase().trim().split(",");
			includedFields = new HashSet<String>(Arrays.asList(parsedFields));
		}else {
			includedFields = new HashSet<String>();
		}
		
		Board savedBoard = repository.getBoard(boardId);

		res = savedBoard.filterFields(includedFields);
		if(savedBoard.getType().equals(BoardType.PRIVATE)) {
			res = res.secureBoard();
		}
				
		return res;
	}
	
	@GET
	@Path("/visibles")
	@Produces("application/json")	
	public Collection<Board> getAllVisible(@QueryParam("fields") String fields){
		Set<String> includedFields;
		if(fields!=null&&!fields.isEmpty()) {
			String[] parsedFields = fields.toLowerCase().trim().split(",");
			includedFields = new HashSet<String>(Arrays.asList(parsedFields));
		}else {
			includedFields = new HashSet<String>();
		}
		
		Collection<Board> res = filterFieldsAll(repository.getAllVisibleBoards(), includedFields);
		
		return res;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createBoard(@Context UriInfo uriInfo, BoardJSON boardJSON) {
		Board board = boardJSON.getBoard();
		validateBoard(board);
		Board savedBoard = repository.createBoard(board);
		
		//Build the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getBoard");
		URI uri = ub.build(savedBoard.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(savedBoard.secureBoard());
		return resp.build();
	}
	
	private void validateBoard(Board board) {
		
	}
	
	private Collection<Board> filterFieldsAll(Collection<Board> boards, Set<String> includedFields) {
		Collection<Board> res = new HashSet<Board>();
		
		for(Board b:boards) {
			res.add(b.filterFields(includedFields));

		}
		return res;
	}
	
	private Collection<Board> secureAllBoards(Collection<Board> boards, Set<String> includedFields) {
		Collection<Board> res = new HashSet<Board>();
		
		for(Board b:boards) {
			res.add(b.filterFields(includedFields).secureBoard());

		
		
		}
		return res;
	}
	
	
	

}
