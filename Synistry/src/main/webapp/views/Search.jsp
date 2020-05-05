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

</main>
    		
    		
    		
    		<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
  </body>
   
</html>
    