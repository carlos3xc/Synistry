package aiss.api.model.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Board;
import aiss.api.model.BoardType;
import aiss.api.model.Comment;
import aiss.api.model.Idea;
import aiss.api.model.Topic;
import aiss.api.model.TopicReference;
import aiss.api.model.utils.AlphanumericSequence;

public class SynistryRepositoryClass implements SynistryRepository{
	
	Map<String, Idea> ideasMap;
	Map<String, Comment> commentsMap;
	Map<String, Topic> topicsMap;
	Map<String, Board> boardsMap;
	
	private static SynistryRepositoryClass _instance=null;
	private static AlphanumericSequence ideasSequence = new AlphanumericSequence(4);
	private static AlphanumericSequence commentsSequence = new AlphanumericSequence(5);
	private static AlphanumericSequence boardsSequence = new AlphanumericSequence(2);
	
	
	public static SynistryRepositoryClass getInstance() {
		
		if (_instance==null) {
			_instance = new SynistryRepositoryClass();
			_instance.init();
		}
		
		return _instance;
	}
	
	public void init() {
		this.ideasMap = new HashMap<String,Idea>();
		this.commentsMap = new HashMap<String, Comment>();
		this.topicsMap = new HashMap<String, Topic>();
		this.boardsMap = new HashMap<String, Board>();
		
		/*Initialize topics*/
		initTopics(topicsMap);
		
		/*Initialize ideas*/
		for(Idea idea: generateIdeas()) {
			createIdea(idea);
		}
		
		/*Initialize comments*/
		Iterator<Idea> ideasCommentsIterator = ideasMap.values().iterator();
		Comment comment1Idea1 = new Comment("Synistry", "https://synistry.appspot.com/", "Esto es un comentario, las ideas pueden ser comentadas", "");
		createComment(comment1Idea1, ideasCommentsIterator.next().getId());
		Comment comment2Idea2 = new Comment("Synistry", "https://synistry.appspot.com/", "Tambien es posible añadir links externos", "https://github.com/carlos3xc/Synistry");
		createComment(comment2Idea2, ideasCommentsIterator.next().getId());
		Comment comment3Idea3 = new Comment("Synistry", "https://synistry.appspot.com/", "Esto es un comentario, las ideas pueden ser comentadas", "https://github.com/carlos3xc/Synistry");
		createComment(comment3Idea3, ideasCommentsIterator.next().getId());
		
		/*Initialize boards*/
		Iterator<Idea> ideasToBoardIterator = ideasMap.values().iterator();
		
		Board board1Public = Board.createBoard("Synistry 2020", 
				"https://synistry.appspot.com/", 
				"Tablón público de Synistry",
				"Sube aquí tus creaciones, no hay límites. Este tablero es moderado por los administradores del sitio.",
				"Synistry1",
				BoardType.PUBLIC);
		board1Public = createBoard(board1Public);
		addIdeaToPublicBoard(ideasToBoardIterator.next(), board1Public.getId());
		addIdeaToPublicBoard(ideasToBoardIterator.next(), board1Public.getId());
		addIdeaToPublicBoard(ideasToBoardIterator.next(), board1Public.getId());
		addIdeaToPublicBoard(ideasToBoardIterator.next(), board1Public.getId());
		addIdeaToPublicBoard(ideasToBoardIterator.next(), board1Public.getId());
		Board board2Protected = Board.createBoard("Synistry 2020", 
				"https://synistry.appspot.com/", 
				"Tablón protegido de Synistry",
				"Este tablero es gestionado por los administradores del sitio, pero cualquiera puede consultarlo.",
				"Synistry2",
				BoardType.PROTECTED);
		board2Protected = createBoard(board2Protected);
		addIdeaToProtectedOrPrivateBoard(ideasToBoardIterator.next(), board2Protected.getId(), "Synistry2");
		addIdeaToProtectedOrPrivateBoard(ideasToBoardIterator.next(), board2Protected.getId(), "Synistry2");
		addIdeaToProtectedOrPrivateBoard(ideasToBoardIterator.next(), board2Protected.getId(), "Synistry2");
		Board board3Private = Board.createBoard("Synistry 2020", 
				"https://synistry.appspot.com/", 
				"Tablón privado de Synistry",
				"Este tablero es gestionado por los administradores del sitio, solo la gente con contraseña puede verlo.",
				"Synistry3",
				BoardType.PRIVATE);
		board3Private = createBoard(board3Private);
		addIdeaToProtectedOrPrivateBoard(ideasToBoardIterator.next(), board3Private.getId(), "Synistry3");
		addIdeaToProtectedOrPrivateBoard(ideasToBoardIterator.next(), board3Private.getId(), "Synistry3");
		addIdeaToProtectedOrPrivateBoard(ideasToBoardIterator.next(), board3Private.getId(), "Synistry3");
		
	}

	@Override
	public Idea createIdea(Idea idea) {
		idea.setId(ideasSequence.next());
		idea.setDate(new Date());
		idea.setComments(new HashSet<Comment>());
		Topic topic = getTopic(idea.getTopicReference().getTopicId());
		/*Just in case, we update de TopicReference within the idea*/
		idea.setTopicReference(new TopicReference(idea.getTopicReference().getTopicId(), topic.getName()));
		topic.addIdea(idea);
		ideasMap.put(idea.getId(), idea);
		return idea;
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
		
		String[] parsedQuery = query.toLowerCase().replaceAll("[;:()/\"]", "").trim().split(",");
		Set<String> queryWordSet = new HashSet<String>(Arrays.asList(parsedQuery));
		
		for(Idea idea:getAllIdeas()) {
			if(anyWordIsContainedIn(idea.getTitle(),queryWordSet)
					||anyWordIsContainedIn(idea.getText(),queryWordSet)
					||anyWordIsContainedIn(idea.getTopicReference().getTopicName(),queryWordSet)) {
				res.add(idea);
			}
		}
		return res;
	}
	
	private static Boolean anyWordIsContainedIn(String string, Set<String> words) {
		Boolean res = false;
		System.out.println("wordSet: " + words.toString());
		for(String word:words) {
			word = word.trim();
			System.out.println("word to check: " + word);
			if(word.isEmpty()||word.equals(" ")) {continue;}
			res=res||string.toLowerCase().contains(word);
			if(res) {break;}
		}
		return res;
	}

	@Override
	public void createComment(Comment comment, String ideaId) {
		comment.setId(commentsSequence.next());
		comment.setDate(new Date());
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
		
		String[] parsedQuery = query.toLowerCase().replaceAll("[;:()/\"]", " ").split(",");
		Set<String> queryWordSet = new HashSet<String>(Arrays.asList(parsedQuery));
		
		for(Idea idea:topic.getIdeas()) {
			if(anyWordIsContainedIn(idea.getTitle(),queryWordSet)
					||anyWordIsContainedIn(idea.getText(),queryWordSet)
					||anyWordIsContainedIn(idea.getTopicReference().getTopicName(),queryWordSet)) {
				res.add(idea);
			}
		}
		return res;
	}
	
	public Board createBoard(Board board) {
		board.setId(boardsSequence.next());
		boardsMap.put(board.getId(), board);
		return board;
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
		if(board==null) {
			throw new NotFoundException("The board with id="+ boardId +" was not found");
		}
		if(!board.getType().equals(BoardType.PRIVATE)) {
			throw new NotFoundException("The board with id="+ boardId +" was not found or is not private");
		}
		if(!board.getPasswordHash().equals(passwordHash)) {
			throw new BadRequestException("The password is not correct");
		}
		if(board.getType().equals(BoardType.PRIVATE)
				&&board.getPasswordHash().equals(passwordHash)) {
			res = getBoard(boardId);
		}
		return res;
	}

	@Override
	public void updateBoard(Board board, String password) {
		Board previousBoard = getBoard(board.getId());
		String passwordHash = new Integer(password.hashCode()).toString();
		if(!board.getPasswordHash().equals(passwordHash)) {
			throw new BadRequestException("The password is not correct");
		}
		if(previousBoard.getPasswordHash().equals(passwordHash)) {
			board.setIdeas(previousBoard.getIdeas());
			if(board.getAuthor()==null) {
				board.setAuthor(previousBoard.getAuthor());
			}
			if(board.getAuthorURL()==null) {
				board.setAuthorURL(previousBoard.getAuthorURL());
			}
			if(board.getTitle()==null||board.getTitle().isEmpty()) {
				board.setTitle(previousBoard.getTitle());
			}
			if(board.getText()==null) {
				board.setText(previousBoard.getText());
			}
			if(board.getType()==null) {
				board.setType(previousBoard.getType());
			}
			if(board.getPasswordHash()==null) {
				board.setPasswordHash(previousBoard.getPasswordHash());
			}
			boardsMap.put(board.getId(), board);
		}else {
		}
		
	}
	
	@Override
	public void deletePrivateBoard(String boardId, String password) {
		Board board = getBoard(boardId);
		String passwordHash = new Integer(password.hashCode()).toString();
		if(board.getPasswordHash().equals(passwordHash)) {
			board.setIdeas(board.getIdeas());
			boardsMap.remove(boardId);
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
	
	@Override
	public Collection<Idea> getIdeasByCollectionIds(Collection<String> ids) {
		Collection<Idea> res = new HashSet<Idea>();
		for(String ideaId:ids) {
			Idea idea = getIdea(ideaId);
			if(idea==null) {
				throw new NotFoundException("The idea with id="+ ideaId +" was not found");
			}else {
				res.add(idea);			
			}
		}
		
		return res;
	}

	@Override
	public void addIdeas(Collection<String> ids, String boardId, String password) {
		Board board = getBoard(boardId);
		if(board==null) {
			throw new NotFoundException("The board with id="+ boardId +" was not found");	
		}
		Collection<Idea> ideas = getIdeasByCollectionIds(ids);
		if(board.getType().equals(BoardType.PUBLIC)) {
			board.getIdeas().addAll(ideas);
		}else {
			if(password==null||password.isEmpty()) {
				throw new BadRequestException("The password was not provided");
			}
			String passwordHash = new Integer(password.hashCode()).toString();
			if(!board.getPasswordHash().equals(passwordHash)) {
				throw new BadRequestException("The password is not correct");
			}
			board.getIdeas().addAll(ideas);
		}
		
	}

	@Override
	public void removeIdeas(Collection<String> ids, String boardId, String password) {
		Board board = getBoard(boardId);
		if(board==null) {
			throw new NotFoundException("The board with id="+ boardId +" was not found");	
		}
		Collection<Idea> ideas = getIdeasByCollectionIds(ids);
		if(board.getType().equals(BoardType.PUBLIC)) {
			board.getIdeas().removeAll(ideas);
		}else {
			if(password==null||password.isEmpty()) {
				throw new BadRequestException("The password was not provided");
			}
			String passwordHash = new Integer(password.hashCode()).toString();
			if(!board.getPasswordHash().equals(passwordHash)) {
				throw new BadRequestException("The password is not correct");
			}
			board.getIdeas().removeAll(ideas);
		}
		
	}

	private void initTopics(Map<String, Topic> topicsMap) {
		
		Topic topic1drawing = new Topic("drawing","Dibujo", "");
		topicsMap.put(topic1drawing.getId(), topic1drawing);
		
		Topic topic2architecture = new Topic("architecture","Arquitectura", "");
		topicsMap.put(topic2architecture.getId(), topic2architecture);
		
		Topic topic3esculpture = new Topic("esculpture","Escultura", "");
		topicsMap.put(topic3esculpture.getId(), topic3esculpture);
		
		Topic topic4painting = new Topic("painting","Pintura", "");
		topicsMap.put(topic4painting.getId(), topic4painting);
		
		Topic topic5ilustration = new Topic("ilustration","Ilustración", "");
		topicsMap.put(topic5ilustration.getId(), topic5ilustration);
		Topic topic6modeling3d = new Topic("3d-modeling","Modelado 3D", "");
		topicsMap.put(topic6modeling3d.getId(), topic6modeling3d);
		
		Topic topic7pixelart = new Topic("Pixel Art", "");
		topicsMap.put(topic7pixelart.getId(), topic7pixelart);
		
		Topic topic8fanarts = new Topic("Fanarts", "");
		topicsMap.put(topic8fanarts.getId(), topic8fanarts);
		
		Topic topic9animation = new Topic("animation","Animación", "");
		topicsMap.put(topic9animation.getId(), topic9animation);
		
		Topic topic10design = new Topic("design","Diseño", "");
		topicsMap.put(topic10design.getId(), topic10design);
		
		Topic topic11photography = new Topic("photography","Fotografía", "");
		topicsMap.put(topic11photography.getId(), topic11photography);
		
		Topic topic12crafting = new Topic("crafting","Manualidades", "");
		topicsMap.put(topic12crafting.getId(), topic12crafting);
	}
	
	private List<Idea> generateIdeas() {
		
		List<Idea> res = new ArrayList<Idea>();
		
		/*Ideas drawing*/
		Idea idea1= new Idea(
				"https://artsketches.burram.com/details/drawings-sketches-posters-pencil-sketch-artist-ideas-/A07C2B1P3SD3XK64/503",
				"https://i.pinimg.com/originals/04/f9/a3/04f9a3664866ac64376caad5d3ac2a9e.png",
				"Art Sketches 2020",
				"artsketches.burram.com our content is determined by the Art Sketches 2020 (#drawings #sketches #posters #pencil #sketch #artist #ideas ) ",
				"drawing"
				);
		res.add(idea1);
		
		Idea idea2= new Idea(
				"https://skyryedesign.com/tutorials/30-anatomy-drawing-ideas/",
				"https://skyryedesign.com/wp-content/uploads/2020/02/8a1100d55a5f299165208067f2263e94.jpg",
				"Body drawing",
				"This collection contains interesting examples and methods of constructing a human figure and individual parts of the body",
				"drawing"
				);
		res.add(idea2);
		
		Idea idea3= new Idea(
				"https://skyryedesign.com/tutorials/30-anatomy-drawing-ideas/",
				"https://skyryedesign.com/wp-content/uploads/2020/02/59cc96bc01396086de691b67d867eac5.jpg",
				"Super heroine posing",
				"A cool drawing of a super woman, maybe captain Marvel",
				"drawing"
				);
		res.add(idea3);
		
		Idea idea4= new Idea(
				"https://skyryedesign.com/tutorials/30-anatomy-drawing-ideas/",
				"https://skyryedesign.com/wp-content/uploads/2020/02/66c65f0f0af0e81fce067d83d93db5f5.jpg",
				"Face study and drawing",
				"",
				"drawing"
				);
		res.add(idea4);
		
		Idea idea5= new Idea(
				"https://brightercraft.com/2019/01/01/30-amazing-hair-drawing-ideas-inspiration/",
				"https://brightercraft.com/wp-content/uploads/2019/01/img_9662.jpg",
				"15 Amazing Hair Drawing Ideas & Inspiration",
				"Need some drawing inspiration? Well you’ve come to the right place! Here’s a list of 15 amazing hair drawing ideas and inspiration.",
				"drawing"
				);
		res.add(idea5);
		
		/*Ideas architecture*/
		Idea idea6= new Idea(
				"https://www.contemporist.com/triangular-house-interior-garden/",
				"https://www.contemporist.com/wp-content/uploads/2019/09/modern-house-triangle-layout-internal-courtyard-290919-829-01.jpg",
				"This Triangular Shaped House Makes Room For An Interior Garden",
				"Inside, the three wings of the house are dedicated to different areas; the great room, the master suite, and the bedroom wing.",
				"architecture"
				);
		res.add(idea6);
		
		Idea idea7= new Idea(
				"https://www.architecturaldigest.com/story/steven-holl-architects-ad100",
				"https://media.architecturaldigest.com/photos/5c08299f1b58382d031ba32b/16:9/w_2560%2Cc_limit/Steven%252520HollGlassell_2C6A4394.jpg",
				"Discover the architecture firm that fuses concept and phenomena",
				"Just Completed: Institute for Contemporary Art, Virginia Commonwealth University; Glassell School of Art, Museum of Fine Arts, Houston.",
				"architecture"
				);
		res.add(idea7);
		
		Idea idea8= new Idea(
				"https://www.arch2o.com/atelie-house-arqexact/",
				"https://www.arch2o.com/wp-content/uploads/2019/07/Arch2O-Ateli%C3%AA-House-Arqexact-29-700x466.jpg",
				"Ateliê House | Arqexact",
				"Arqexact Designed by Arqexact, The Ateliê House was designed to be an artistic refuge, an area of inspiration, contemplation, and tranquility next to nature, placed on an irregular land.",
				"architecture"
				);
		res.add(idea8);
		
		/*Ideas esculpture*/
		Idea idea9= new Idea(
				"https://gimsblog.com/2019/04/26/esculturas-a-detalle/",
				"https://gimsblog.com/wp-content/uploads/2019/04/4a5d1acdb216ba193ac6dc944011cf0b.jpg",
				"Classic sculpture",
				"Enjoy a full gallery of sculptures with precision that seems from another world.",
				"esculpture"
				);
		res.add(idea9);
		
		Idea idea10= new Idea(
				"http://www.todo-mail.com/content.aspx?emailid=13957",
				"https://es.bcdn.biz/Images/2018/6/27/1be0f2d5-c6d5-4c45-ad19-e7757f4bd22b.jpg",
				"Las Magníficas Esculturas De Arcilla De Yuanxing Liang",
				"Yuanxing Liang es un artista chino que crea increíbles esculturas surrealistas de arcilla que combinan elementos de la naturaleza",
				"esculpture"
				);
		res.add(idea10);
		
		/*Ideas painting*/
		Idea idea11= new Idea(
				"https://feelingnifty.com/cherry-blossom-tree-painting-tutorial/",
				"https://feelingnifty.com/wp-content/uploads/2019/11/cherry-blossom-canvas-painting-768x512.jpeg",
				"Painting a Cherry Blossom Tree with Acrylics",
				"Just starting out in your painting journey and looking for an easy painting idea? Painting a cherry blossom tree is a perfect starter canvas project that will add to your confidence with acrylics.",
				"painting"
				);
		res.add(idea11);
		Idea idea12= new Idea(
				"https://www.boredpanda.com/i-accidentally-paint-weather-formations-or-girls-who-apparently-look-like-me/?finerabstractart=7317825611&utm_source=pinterest&utm_medium=social&utm_campaign=organic",
				"https://static.boredpanda.com/blog/wp-content/uploads/2016/08/I-accidentally-paint-weather-formations-or-girls-who-apparently-look-like-me-57a42e814d41a__880.jpg",
				"Calm Waters abstract fluid artwork work in progress…",
				"I used to paint back in high school. And play music and write. I was never discouraged from doing these things I loved",
				"painting"
				);
		res.add(idea12);

		Idea idea13= new Idea(
				"https://www.saatchiart.com/art/Painting-Guaca-hey-hey/1109795/4381390/view?utm_source=google&utm_medium=cpc&utm_campaign=2200",
				"https://images.saatchiart.com/saatchi/1109795/art/4927947/3997771-ZZFEGNMM-7.jpg",
				"Guaca Hey Hey",
				"The guacamaya reflexes throught hs colorful plumage feelings of joy and happiness, it is a beautiful exotic bird in danger of extinction.",
				"painting"
				);
		res.add(idea13);
		
		/*Ideas illustration*/
		
		
		
		/*Ideas crafting*/
		Idea ideac1= new Idea(
				"https://www.handfie.com/manualidades-faciles-para-san-valentin-flores-diy/01627/",
				"https://www.handfie.com/wp-content/uploads/2017/01/Manualidades-faciles-san-valentin-flores-diy-handfie-carton-rollo-de-papel-higienico-2.jpg",
				"Manualidades fáciles para San Valentín: Flores DIY",
				"Y ya pensando a lo grande esta otra idea con el mismo material crea un mural precioso para cualquier espacio de casa.",
				"crafting"
				);
		res.add(ideac1);
		Idea ideac2= new Idea(
				"https://centrosdemesaparabautizos.com/como-hacer-cadenas-de-papel/",
				"https://centrosdemesaparabautizos.com/wp-content/uploads/2019/06/como-hacer-cadenas-de-papel-de-colores.jpg",
				"Tutorial para aprender como hacer cadenas de papel",
				"Estas guirnaldas se adaptan a todos los espacios, decoran tu casa y tu fiesta, ¿la mejor parte? Puedes reciclar y papel hay en todas las casas, siempre hay hojas, facturas y pare de contar.",
				"crafting"
				);
		res.add(ideac2);
		Idea ideac3= new Idea(
				"http://persialou.com/2015/12/5646.html",
				"https://persialou.com/wp-content/uploads/2015/11/emoji-lapel-pins.jpg",
				"DIY Lapel Pins – Emoji Pin Flair!",
				"These DIY Lapel Pins are easy to make with plastic shrink film and are a whole lot of fun to wear! Pick your favorite emoji to wear or give them as gifts!",
				"crafting"
				);
		res.add(ideac3);
		Idea ideac4= new Idea(
				"http://arte2.cornerofwoman.com/mas-ponpones-ideas-de-lindas-pinterest-manualidades-regalos-de-bricolaje-y-bricolaje-crafts/",
				"https://i.pinimg.com/736x/40/a9/7b/40a97b256e96812b601f06e418369617.jpg",
				"Love Coaster with Easel",
				"Una decoración o regalo de bricolaje, rápido y fácil. El \"Love Coaster with Easel\" es uno de los proyectos que hice en el stand de Tape Technologies durante Creativation la semana pasada ",
				"crafting"
				);
		res.add(ideac4);
		Idea ideac5= new Idea(
				"http://bonitismos.com/2020/01/diy-con-ninos-para-dias-lluviosos/",
				"http://bonitismos.com/wp-content/uploads/2020/01/diy-rollos-papel-higienico.jpg",
				"DIY con niños para días lluviosos",
				"Después de un fin de semana bastante casero, hemos tenido que tirar de mucho DIY para entretener a Pablo y, ya de paso, a nosotros mismos. Y como teníamos montones de rollos de papel en casa para reciclar, se nos ocurrió que seguro que podíamos hacer algo chulo con ellos.",
				"crafting"
				);
		res.add(ideac5);
		
		return res;
	}



}
