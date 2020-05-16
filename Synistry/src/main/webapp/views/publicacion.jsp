<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html> 
<html>

<head>
<%@ include file="../masterpage/meta.jsp" %> 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Small Business - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/small-business.css" rel="stylesheet">

</head>

<body>

  <div class="main-container">
  			<%@ include file="../masterpage/header.jsp" %> 
  		
  <!-- Page Content -->
  <div class="container">

    <!-- Heading Row -->
    <div class="row align-items-center my-5">
      <div class="col-lg-7">
        <img class="img-fluid rounded mb-4 mb-lg-0" src="<c:url value="${publicacionResult.preview.src}"/>" alt="">
      </div>
      <!-- /.col-lg-8 -->
      <div class="col-lg-5">
      	<h1>DeviantArt</h1>
        <h1 class="font-weight-light"><c:out value="${publicacionResult.title}"/></h1> 
         <p class="card-auhor">Autor: <c:out value="${publicacionResult.author.username}"/></p>
         
        <a class="btn btn-primary" href="#">Call to Action!</a>
      </div>
      <!-- /.col-md-4 -->
    </div>
    <!-- /.row -->

    <!-- Call to Action Well -->
    <div class="card text-white bg-secondary my-5 py-4 text-center">
      <div class="card-body">
        <p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p>
      </div>
    </div>


  </div>
  <!-- /.container -->

  <!-- Footer -->
 <%@ include file="../masterpage/footer.jsp" %>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
