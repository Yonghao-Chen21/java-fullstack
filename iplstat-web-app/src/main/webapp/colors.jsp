<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<div class="py-2 bg-dark text-white">
		<h1 class="display-5 text-center">Colors Cart Application</h1>
		<p class="lead text-center">Learning HttpSession Concepts using
			color cart application</p>
	</div>

	<div class="container">
		<div class="row justify-content-md-right">
			<div class="col-md-2">
				<a href='logout.do'>Logout</a>
			</div>
		</div>
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">

				<form action="addcolortocart.do">
					<select class="form-select" onchange="submitForm(this)"
						name="color">
						<option selected value="">Select Color</option>
						<option value="Blue">Blue</option>
						<option value="Green">Green</option>
						<option value="Yellow">Yellow</option>
						<option value="Orange">Orange</option>
						<option value="Pink">Pink</option>
					</select>
				</form>
			</div>
		</div>
		<c:if test="${colorList.size() > 0}">
			<div class="row mt-2">
				<div class="col-md-4 offset-md-4">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Color</th>
								<th scope="col">Remove</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${colorList}" var="color" varStatus="i">

								<tr>
									<td scope="row">${i.index + 1}</td>
									<td>${color}</td>
									<td><a href='removeitemfromcart.do?color=${color}'>Remove</a></td>
								</tr>


							</c:forEach>

							<tr>
								<td colspan="3" style="text-align: right"><a
									href='removeallitemfromcart.do'>Remove All</a></td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</c:if>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		function submitForm(elem) {
			console.log(elem)
			if (elem.value) {
				elem.form.submit();
			}
		}
	</script>
</body>
</html>