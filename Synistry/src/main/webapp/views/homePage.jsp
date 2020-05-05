<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
  <head>
  <%@ include file="../masterpage/meta.jsp" %> 
    <title>Synistry</title>
  </head>

	<body>
	<div class="main-container">
  			<%@ include file="../masterpage/header.jsp" %> 
  		
  		<main role="main" class="container content">
	  			<form class="form-search-landing text-center" action="SearchController" method="post">
		  			<div class="padding-spacing-vertical">
			  			<img alt="Synistry" src="../images/Synistry-logo-letras.png" width="65%" class="padding-spacing-vertical">
				      	<input class="form-control padding-spacing-vertical" name="query"  type="search" placeholder="Estilo o concepto artístico" aria-label="Search" autofocus="">
				     	<button class="btn btn-dark btn-lg padding-spacing-vertical" type="submit">Buscar</button>
		  		
			      
		    	</form>
		    	<h2>Descripción</h2>
		    	<p>Synistry es un mashup para ayudar a los artistas a superar los bloqueos creativos. 
		    	Empezando por una simple idea o concepto, podemos empezar a navegar entre millones de publicaciones de otros usuarios,
		    	viendo en un mismo sitio contenido de Pintarest, DevianArt y Reddit.</p>
		    	<p>No solo podemos ver contenido, sino que también podemos autenticarnos en las plataformas para las que se dan soporte
		    	y publicar con un solo click en todas nuestras plataformas, lo que te hará más fácil cuidar tu prescencia online y aumentar tus seguidores.</p>
		    	<br/>
		    	<h2>Integrantes</h2>
			    	<ul>
			    		<li>Carlos Manuel Cabello Colmenares (carcabcol@alum.us.es)</li>
			    		<li>José Martín Sánchez (josmarsan24@alum.us.es)</li>
			    		<li>Juan Antonio Mena Vargas (Juanantoniomenavargas@gmail.com)</li>
			    		<li>Rafael Díaz García (rafadg9@gmail.com)</li>
			    	</ul>
			    <br/>
			    <h2>APIs a integrar</h2>
			    	<ul>
			    		<li><a href="https://developers.pinterest.com/docs/getting-started/introduction/?">Pintarest</a></li>
			    		<li><a href="https://www.deviantart.com/developers/">DevianArt</a></li>
			    		<li><a href="https://www.reddit.com/dev/api/">Reddit</a></li>
			    		<li><a href="https://developer.dribbble.com/v2/">Dribble</a></li>
			    	</ul>
			    <br/>
    	</main>
    		<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
  </body>
   
</html>
    