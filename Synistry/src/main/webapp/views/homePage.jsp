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
	  			<form class="form-search-landing text-center">
		  			<div class="padding-spacing-vertical">
			  			<img alt="Synistry" src="../images/Synistry-logo.png" width="65%" class="padding-spacing-vertical">
				      	<input class="form-control padding-spacing-vertical" type="search" placeholder="Estilo o concepto artístico" aria-label="Search" autofocus="">
				     	<button class="btn btn-danger btn-lg padding-spacing-vertical" type="submit">Buscar</button>
		  			</div>
			      
		    	</form>      
    	</main>
    		<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
  </body>
   
</html>
    