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
		<fieldset id = "placebo">
			<legend>Estado del placebo</legend>
			<span>Es: <c:out value='${requestScope.resultado}'/></span>
		</fieldset>
</body>
   
</html>
    