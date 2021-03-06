<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
  <head>
  <%@ include file="../masterpage/meta.jsp" %> 
    <title>AboutUs</title>
  </head>

<body>
<div class="main-container">
	<%@ include file="../masterpage/header.jsp" %> 
	<div class = "padding-spacing-vertical padding-spacing-sides">
		<h2>Descripci�n</h2>
		    	<p>Synistry es un mashup para ayudar a los artistas a superar los bloqueos creativos. 
		    	Empezando por una simple idea o concepto, podemos empezar a navegar entre millones de publicaciones de otros usuarios,
		    	viendo en un mismo sitio contenido de Museum, DevianArt y Giphy.</p>
		    	<p>No solo podemos ver contenido, sino que tambi�n podemos autenticarnos en las plataformas para las que se dan soporte
		    	y publicar con un solo click en todas nuestras plataformas, lo que te har� m�s f�cil cuidar tu prescencia online y aumentar tus seguidores.</p>
		    	<br/>
		    	<h2>Integrantes</h2>
			    	<ul>
			    		<li>Carlos Manuel Cabello Colmenares (carcabcol@alum.us.es)</li>
			    		<li>Jos� Mart�n S�nchez (josmarsan24@alum.us.es)</li>
			    		<li>Juan Antonio Mena Vargas (Juanantoniomenavargas@gmail.com)</li>
			    		<li>Rafael D�az Garc�a (rafadg9@gmail.com)</li>
			    	</ul>
			    <br/>
			    <h2>APIs a integrar</h2>
			    	<ul>
			    		<li><a href="https://api.giphy.com/">Giphy</a></li>
			    		<li><a href="https://www.deviantart.com/developers/">DevianArt</a></li>
			    		<li><a href="https://www.rijksmuseum.nl/">Museum</a></li>
			    	</ul>
			    	</div>
			    <br/>
			    	<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
</body>
   
</html>
    