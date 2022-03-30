<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="header.jsp"></c:import>

<div class="container">

	<div class="row">
		<div class="col-md-8 offset-md-2">
			<c:if test="${teamStatList.size() > 0}">
				<table class="table table-striped">
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

		</div>
	</div>

</div>

<c:import url="footer.jsp"></c:import>
