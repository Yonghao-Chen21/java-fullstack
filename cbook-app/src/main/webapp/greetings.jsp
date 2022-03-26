<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greetings</title>
</head>
<body>
		Hello <b> ${user}</b>		
		<ul>
		<c:forEach items="${friends}" var="name">
			<li>${name}</li>
		</c:forEach>
		</ul>
		<a href="index.html">Home</a>
</body>
</html>