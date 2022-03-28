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

    <c:if test="${teamStatList.size() > 0}">
	<table border="1" style="width: 60%;margin-left: 20%;margin-right: 20%">
		<thead>
			<tr>
				<th>Team_Code</th>
				<th>Team_Name</th>
				<th>Total_Amount</th>
				<th>Player_count</th>
				<th>Avg_Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${teamStatList}" var="team">
				<tr>
					<td>${team.teamCode}</td>
					<td>${team.teamName}</td>
					<td>${team.totalAmount}</td>
					<td>${team.playerCount}</td>
					<td>${team.avgAmount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<a href="index.html">Home</a>
</body>
</html>