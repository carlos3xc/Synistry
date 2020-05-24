package aiss.api.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Board;
import aiss.api.model.BoardType;
import aiss.api.model.repository.SynistryRepository;
import aiss.api.model.repository.SynistryRepositoryClass;
import aiss.api.resources.utilities.BoardJSON;
import aiss.api.resources.utilities.PasswordBoardJSON;

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
	
	@POST
	@Path("/private/{id}")
	@Consumes("application/json")
	@Produces("application/json")	
	public Board getPrivateBoard(@QueryParam("fields") String fields, @PathParam("id") String boardId, PasswordBoardJSON passwordBoardJSON){
		Board res;
		Set<String> includedFields;
		if(fields!=null&&!fields.isEmpty()) {
			String[] parsedFields = fields.toLowerCase().trim().split(",");
			includedFields = new HashSet<String>(Arrays.asList(parsedFields));
		}else {
			includedFields = new HashSet<String>();
		}
		
		Board savedBoard = repository.getPrivateBoard(boardId, passwordBoardJSON.getPassword());

		res = savedBoard.filterFields(includedFields);
				
		return res;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")	
	public Response updateBoard(@PathParam("id") String boardId, PasswordBoardJSON passwordBoardJSON){
		validatePassword(passwordBoardJSON);
		Board savedBoard = repository.getPrivateBoard(boardId, passwordBoardJSON.getPassword());
		if(savedBoard==null) {
			throw new NotFoundException("The board with id="+ boardId +" was not found");	
		}
		repository.updateBoard(passwordBoardJSON.toBoard(boardId), passwordBoardJSON.getPassword());
				
		return Response.noContent().build();
	}
	
	private void validatePassword(PasswordBoardJSON passwordBoardJSON) {
		if(passwordBoardJSON.getPassword()==null||passwordBoardJSON.getPassword().isEmpty()) {
			throw new BadRequestException("A password must be provided to administer a Board");
		}
	}

	
	@DELETE
	@Consumes("application/json")
	@Path("/{id}/{password}")
	public Response deleteBoard(@PathParam("id") String boardId, @PathParam("password") String password){
		if(password==null||password.isEmpty()) {
			throw new BadRequestException("A password must be provided to administer a Board");
		}
		Board savedBoard = repository.getPrivateBoard(boardId, password);
		if(savedBoard==null) {
			throw new NotFoundException("The board with id="+ boardId +" was not found");	
		}
		repository.deletePrivateBoard(boardId, password);
				
		return Response.noContent().build();
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
		validateBoard(boardJSON);
		Board board = boardJSON.getBoard();
		Board savedBoard = repository.createBoard(board);
		
		//Build the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getBoard");
		URI uri = ub.build(savedBoard.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(savedBoard.secureBoard());
		return resp.build();
	}
	
	private void validateBoard(BoardJSON boardJSON) {
		if(boardJSON.getAuthor()!=null&&boardJSON.getAuthor().isEmpty()) {
			throw new BadRequestException("The author, if provided, must not be a blank");
		}
		if(boardJSON.getAuthorURL()!=null&&boardJSON.getAuthorURL().isEmpty()) {
			throw new BadRequestException("The authorURL, if provided, must not be a blank");
		}
		if(boardJSON.getPassword()==null||boardJSON.getPassword().isEmpty()) {
			throw new BadRequestException("A password must be provided to create a new Board");
		}
		if(boardJSON.getTitle()==null||boardJSON.getTitle().isEmpty()) {
			throw new BadRequestException("A title must be provided to create a new Board");
		}
		if(boardJSON.getType()==null||boardJSON.getType().isEmpty()) {
			throw new BadRequestException("A BoardType(PUBLIC, PRIVATE, PROTECTED) must be provided to create a new Board");
		}
		if(!boardJSON.getType().toUpperCase().equals(BoardType.PUBLIC.toString())
				&&!boardJSON.getType().toUpperCase().equals(BoardType.PRIVATE.toString())
				&&!boardJSON.getType().toUpperCase().equals(BoardType.PROTECTED.toString())) {
			throw new BadRequestException("A boardType does not match PUBLIC, PRIVATE or PROTECTED)");
		}
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
