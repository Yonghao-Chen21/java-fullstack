<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IPL Role Amounts JSP</title>
</head>
<body>

	<form action="roleamount">
		<select name="teamCode">
			<c:forEach items="${teamCodes}" var="teamCode">
				<option value="${teamCode}">${teamCode}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Get Role Amount Details"> 
	</form>
	<hr>
	<c:if test="${rlist.size() > 0}">
	<h1 align="center">${teamName}</h1>
	<table border="1" style="width: 60%;margin-left: 20%;margin-right: 20%">
		<thead>
			<tr>
				<th>Role</th>
				<th>sum of Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rlist}" var="r">
				<tr>
					<td>${r.getRole().name()}</td>
					<td>${r.getAmount()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<c:if test="${plist.size() == 0}">
		<p>Please select the team to see role amount details</p>
	</c:if>
	<a href="index.html">Home</a>
</body>
</html>