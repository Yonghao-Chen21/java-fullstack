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
		<h1 class="display-5 text-center">Shopping Cart Application</h1>
		<p class="lead text-center">Learning HttpSession Concepts using
			shopping cart application</p>
	</div>

	<div class="container">
		<div class="row justify-content-md-right">
			<div class="col-md-2">
				<a href='logout.do2'>Logout</a>
			</div>
		</div>
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">

				<form action="additemtocart.do2">
					<select class="form-select" onchange="submitForm(this)"
						name="itemName">
						<option selected value="">Select Item</option>
						<c:forEach items="${items}" var="i">
							<option value="${i.getName()}">${i.getName()}UnitPrice:
								${i.getPrice()}</option>
						</c:forEach>
					</select>
				</form>
			</div>
		</div>
		<c:if test="${order.size() > 0}">
			<div class="row mt-2">
				<div class="col-md-4 offset-md-4">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Item</th>
								<th scope="col">Unit Price</th>
								<th scope="col">Count</th>
								<th scope="col">Amount</th>
								<th scope="col">Remove</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${order}" var="entry" varStatus="i">
								<tr>
									<td scope="row">${i.index + 1}</td>
									<td>${entry.key.getName()}</td>
									<td>${entry.key.getPrice()}</td>
									<td>${entry.value}</td>
									<td>${orderSum.get(entry.key)}</td>
									<td><a
										href='removeitemfromcart.do2?itemName=${entry.key.getName()}'>Remove</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="3" style="text-align: left">Total Amount: ${totalAmount}</td>
							</tr>
							<tr>
								<td colspan="3" style="text-align: left"><a
									href='removeallitemfromcart.do2'>Remove All</a></td>
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