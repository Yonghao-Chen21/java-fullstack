<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IPL Players JSP</title>
</head>
<body>

	<form action="player">
		<select name="teamCode">
			<c:forEach items="${teamCodes}" var="teamCode">
				<option value="${teamCode}">${teamCode}</option>
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
					<td>${p.getName()}</td>
					<td>${p.getRole().name()}</td>
					<td>${p.getPrice()}</td>
					<td>${p.getCountry()}</td>
					<td>${p.getTeam()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<c:if test="${plist.size() == 0}">
		<p>Please select the team to see player details</p>
	</c:if>
	<a href="index.html">Home</a>
</body>
</html>