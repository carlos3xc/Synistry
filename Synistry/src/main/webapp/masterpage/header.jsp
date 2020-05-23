<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<header>
	<nav class="navbar navbar-expand-sm .bg-light navbar-light menu-superior">
	  <a class="navbar-brand" href="/#"><img alt="Synistry" src="../images/Synistry-logo.png" height="75px"></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="collapsibleNavbar">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item">
	      <form class="form-inline " action="/SearchController" method="get">
		    <input class="form-control mr-sm-2 padding-spacing-sides" type="search" name="query" placeholder="Estilo o concepto..." aria-label="Search">
		    <button class="btn btn-dark my-2 my-sm-0" type="submit">Buscar</button>
		    </form>
	      </li>
		    </ul>
			
			 
				<c:choose>
					<c:when test='${empty sessionScope["Deviantart-token"]}'>
						<a href="/AuthController/Deviantart"class="btn btn-dark btn-lg padding-spacing-sides">Deviantart Login</a>
					</c:when>
					<c:otherwise>
						<span class="padding-spacing-sides"> Deviantart Logged </span>
					</c:otherwise>
				</c:choose> 
			

 </div>  
	</nav>
</header>