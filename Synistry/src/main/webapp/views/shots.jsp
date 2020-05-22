<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
  <head>
  <%@ include file="../masterpage/meta.jsp" %> 
    <title>Error</title>
  </head>
	<body>
		 <div class="row">
  	 		  <c:forEach items="${requestScope.shots}" var = "shot">
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="<c:url value="${shot.images.normal}"/>" alt="">
					          <div class="card-body">
					            <h4 class="card-title"><c:out value="${shot.title}"/></h4>
					          </div>
					          <div class="card-footer">
					            <a href="#" class="btn btn-primary">Abrir</a>
					          </div>
					        </div>
					      </div>
					    </c:forEach>
					    </div>
</body>
   
</html>
    