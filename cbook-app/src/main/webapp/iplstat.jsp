<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IPL stat JSP</title>
</head>
<body>

	<form action="iplstat">
		<select name="teamName">
			<c:forEach items="${teamNames}" var="teamName">
				<option value="${teamName}">${teamName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Get Player Details"> 
	</form>
	<hr>
	<c:if test="${plist.size() > 0}">
	<table border="1" style="width: 60%;margin-left: 20%;margin-right: 20%">
		<thead>
			<tr>
				<th>Name</th>
				<th>Role</th>
				<th>Price</th>
				<th>Country</th>
				<th>Team</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${plist}" var="p">
				<tr>
					<td>${p.name}</td>
					<td>${p.role}</td>
					<td>${p.price}</td>
					<td>${p.country}</td>
					<td>${p.team}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<c:if test="${plist.size() == 0}">
		<p>Please select the team to see player details</p>
	</c:if>
</body>
</html>