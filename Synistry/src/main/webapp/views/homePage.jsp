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
	  			<form class="form-search-landing text-center">
		  			<div class="padding-spacing-vertical">
			  			<img alt="Synistry" src="../images/Synistry-logo-letras.png" width="65%" class="padding-spacing-vertical">
				      	<input class="form-control padding-spacing-vertical" type="search" placeholder="Estilo o concepto artístico" aria-label="Search" autofocus="">
				     	<button class="btn btn-dark btn-lg padding-spacing-vertical" type="submit">Buscar</button>
		  			</div>
			      
		    	</form>
		    	
		    	
		    	<c:choose>
					<c:when test='${empty sessionScope["Deviantart-token"]}'>
					</c:when>
					<c:otherwise>    	
					    <div class="row">
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="http://placehold.it/300x200" alt="">
					          <div class="card-body">
					            <h4 class="card-title">Card title</h4>
					            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque sequi doloribus.</p>
					          </div>
					          <div class="card-footer">
					            <a href="#" class="btn btn-primary">Find Out More!</a>
					          </div>
					        </div>
					      </div>
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="http://placehold.it/300x200" alt="">
					          <div class="card-body">
					            <h4 class="card-title">Card title</h4>
					            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque sequi doloribus totam ut praesentium aut.</p>
					          </div>
					          <div class="card-footer">
					            <a href="#" class="btn btn-primary">Find Out More!</a>
					          </div>
					        </div>
					      </div>
					      <div class="col-md-4 mb-5">
					        <div class="card h-100">
					          <img class="card-img-top" src="http://placehold.it/300x200" alt="">
					          <div class="card-body">
					            <h4 class="card-title">Card title</h4>
					            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
					          </div>
					          <div class="card-footer">
					            <a href="#" class="btn btn-primary">Find Out More!</a>
					          </div>
					        </div>
					      </div>
					    </div>
					</c:otherwise>
				</c:choose> 
    	</main>
    		<%@ include file="../masterpage/footer.jsp" %>
    	</div> 
  </body>
   
</html>
    