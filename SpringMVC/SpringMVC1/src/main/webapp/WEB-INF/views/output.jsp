<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	
<div class="container">
		<h2>Contact Details</h2>
		<form role="form" action="customer/save" method="post">
			<input type="hidden" name="id">
			<label for="title">Title</label>
			<input type="text" class="form-control" id="title" name="title"/>
			<label for="name">Customer Name</label>
			<input type="text" class="form-control" id="name" name="name"/>
			<label for="name">Company</label>
			<input type="text" class="form-control" id="company" name="company"/>
			<label for="name">Phone</label>
			<input type="text" class="tel form-control" id="phone" name="phone"/>
			
			<input type="submit" value="Submit"/>
		</form>

	<table class="table-responsive" border="1">
		<c:forEach var="customer" items="${customerList}">
			<tr>
				<td>${customer.title}</td><td>${customer.name}</td><td>${customer.company}</td><td>${customer.phone}</td><td><input type="button" class="btn btn-default" value="delete" onclick="window.location='customer/delete?id=${customer.id}'"/></td>
			</tr>
		</c:forEach>
	</table>	
</div>
</body>
</html>