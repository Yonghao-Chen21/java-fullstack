<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="header.jsp"></c:import>

<div class="container">
	<div class="row mt-2">

		<c:forEach items="${teamStatList}" var="team">
			<div class="col-md-3">
				<div class="card">
					<div class="card-body">
						${team.teamCode}- <strong>${team.teamName}</strong>-
						${team.totalAmount}- ${team.playerCount}- ${team.avgAmount}

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<c:import url="footer.jsp"></c:import>