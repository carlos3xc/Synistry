<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
</head>
<header>
	<nav class="navbar navbar-expand-sm .bg-light navbar-light menu-superior">
	  <a class="navbar-brand" href="/#"><img alt="Synistry" src="../images/Synistry-logo.png" height="75px"></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav mr-auto">
	      <!--  
	      <li class="nav-item">
	        <a class="nav-link" href="#">Sobre nosotros</a>
	      </li>
	      -->    
	    </ul>
	    <form class="form-inline">
	    <c:choose>
	    	<c:when test='${empty sessionScope["devianart-token"]}'>
		   		 <a href="/AuthController/devianart" class="btn btn-dark my-2 my-sm-0"  >DevianArt ></a>
		    </c:when>
		    <c:otherwise>
		    	<c:forEach items ="${requestScope.devianartProfileImage}" var="devianartProfileImage">
		   		<img src="${devianartProfileImage}" alt="dV logged">
		   		</c:forEach>
		    </c:otherwise>
		</c:choose>
	  	</form>
	  </div>  
	</nav>
</header>