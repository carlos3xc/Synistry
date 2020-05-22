<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
  	 		
  	 		
  	 		<h1>Rijksmuseum</h1>
  	 		 <div class="row">
  	 		  <c:forEach items="${requestScope.resultadosMuseum}" var = "resultadoMuseum">
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="<c:url value="${resultadoMuseum.webImage.url}"/>" alt="">
					          <div class="card-body">
					            <h4 class="card-title"><c:out value="${resultadoMuseum.title}"/></h4>
					             <p class="card-auhor">Autor: <c:out value="${resultadoMuseum.principalOrFirstMaker}"/></p>
					          </div>
					    
					        </div>
					      </div>
					    </c:forEach>
					    </div>
  	 		
  	 		
  	 		<h1>Giphy</h1>
  	 		 <div class="row">
  	 		  <c:forEach items="${requestScope.resultadosGiphy}" var = "ResultadoGiphy">
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="<c:url value="${ResultadoGiphy.images.original.url}"/>" alt="">
					          <div class="card-body">
					            <h4 class="card-title"><c:out value="${ResultadoGiphy.title}"/></h4>
					          </div>
					          <div class="card-footer">
					            <a href="#" class="btn btn-primary">Abrir</a>
					          </div>
					        </div>
					      </div>
					    </c:forEach>
					    </div>
			<h1>Deviantart</h1>
  	 		 <div class="row">
					    <c:forEach items="${requestScope.deviationResults}" var = "publicacionPopular">
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="<c:url value="${publicacionPopular.preview.src}"/>" alt="">
					          <div class="card-body">
					            <h4 class="card-title"><c:out value="${publicacionPopular.title}"/></h4>
					            <p class="card-auhor">Autor: <c:out value="${publicacionPopular.author.username}"/></p>

					            <p class="card-auhor">id: <c:out value="${publicacionPopular.deviationid}"/></p>
					          </div>
					          <div class="card-footer">
					          <form class="form-search-landing text-center" action="/oauth2callback/PublicacionController" method="get">
					          <input class="form-control padding-spacing-vertical" name="deviationId"  type="hidden" value="${publicacionPopular.deviationid}">
					          <button class="btn btn-primary" type="submit">Abrir</button>
					          </form>
					          </div>
					        </div>
					      </div>
					      </c:forEach>
					    </div>


</main>
    		
    		
    		
    		<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
  </body>
   
</html>
    