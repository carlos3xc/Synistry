<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	  			<form class="form-search-landing text-center" action="/SearchController" method="get">
		  			<div class="padding-spacing-vertical">
			  			<img alt="Synistry" src="../images/Synistry-logo-letras.png" width="65%" class="padding-spacing-vertical">
				      	<input class="form-control padding-spacing-vertical" name="query"  type="search" placeholder="Estilo o concepto artístico" aria-label="Search" autofocus="">
				     	<button class="btn btn-dark btn-lg padding-spacing-vertical" type="submit">Buscar</button>
			      	</div>
		    	</form>
		    	<c:choose>
					<c:when test='${empty sessionScope["Deviantart-token"]}'>

					</c:when>
					<c:otherwise>    	
					<form id="popularForm" class="text-center" action="/oauth2callback/PopularController" method="get">
			 			<input type="submit" name="popularBtn" title="popular" value="Mostrar Populares de Deviantart y Giphy" class="btn btn-light btn-lg padding-spacing-vertical">
			 		</form>
					</c:otherwise>
				</c:choose> 
    	</main>
    		<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
  </body>
   
</html>
    z