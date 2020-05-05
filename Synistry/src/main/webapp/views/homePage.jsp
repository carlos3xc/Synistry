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
	  			<form class="form-search-landing text-center" action="SearchController" method="post">
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
					<form id="popularForm" action="popularDeviantartController" method="get">
			 			<input type="submit" name="popularBtn" title="popular" value="Mostrar Populares Deviantart" class="btn btn-dark btn-lg padding-spacing-vertical">
			 		</form>
					    <div class="row">
					    <c:forEach items="${requestScope.publicacionesPopular}" var = "publicacionPopular">
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="<c:url value="${publicacionPopular.preview.src}"/>" alt="">
					          <div class="card-body">
					            <h4 class="card-title"><c:out value="${publicacionPopular.title}"/></h4>
					            <p class="card-auhor">Autor: <c:out value="${publicacionPopular.author.username}"/></p>
					          </div>
					          <div class="card-footer">
					            <a href="#" class="btn btn-primary">Abrir</a>
					          </div>
					        </div>
					      </div>
					      </c:forEach>
					    </div>
					</c:otherwise>
				</c:choose> 
    	</main>
    		<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
  </body>
   
</html>
    