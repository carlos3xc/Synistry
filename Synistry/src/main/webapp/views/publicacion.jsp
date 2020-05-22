<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
<%@ include file="../masterpage/meta.jsp"%>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Small Business - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/small-business.css" rel="stylesheet">

</head>

<body style="padding-top: 0px">

	<div class="main-container">
		<%@ include file="../masterpage/header.jsp"%>

		<!-- Page Content -->
		<div class="container">

			<!-- Heading Row -->
			<div class="row align-items-center my-5">
				<div class="col-lg-7">
					<img class="img-fluid rounded mb-4 mb-lg-0"
						src="<c:url value="${publicacionResult.preview.src}"/>" alt="">
				</div>
				<!-- /.col-lg-8 -->
				<div class="col-lg-5">
					<h1>DeviantArt</h1>
					<h1 class="font-weight-light">
						<c:out value="${publicacionResult.title}" />
					</h1>
					<p class="card-auhor">
						Autor:
						<c:out value="${publicacionResult.author.username}" />
					</p>

					<a class="btn btn-primary"
						href=<c:out value="${publicacionResult.url}"/>>Call to Action!</a>
				</div>
				<!-- /.col-md-4 -->
			</div>
			<!-- /.row -->

			<!-- Call to Action Well -->
			<div class="card text-white bg-secondary mt-5 py-4 text-center" >
				<div class="card-body">
					<form class="text-left" action="/CommentController" method="post">
						<h1>Nuevo comentario</h1>
						<input class="form-control padding-spacing-vertical" name="body"
							type="text" placeholder="Comentario" autofocus=""> <input
							class="form-control padding-spacing-vertical" name="deviationId"
							type="hidden" value="${publicacionResult.deviationid}">
						<button class="btn btn-dark btn-lg padding-spacing-vertical"
							type="submit">Comentar</button>

					</form>
				</div>
			</div>
			
			<hr>
			
			<c:forEach items="${requestScope.coms.thread}" var="comentario">
				<div class="card text-white bg-secondary my-5 py-4 text-left">

					<img class="img-rounded padding-spacing-sides"
						src="<c:url value="${comentario.user.usericon}" />" alt=""
						width="40" height="40">
					<div class="card-body">
						<p>
							<c:out value="${comentario.user.username}" />
						</p>
						<hr />
						<h1>
							<c:out value="${comentario.body}" />
						</h1>
					</div>
				</div>
			</c:forEach>



			

		</div>
		<br>
		<!-- /.container -->

		<!-- Footer -->
		<%@ include file="../masterpage/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	</div>
</body>
</html>
