<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
	<h1>Welcome <%=request.getParameter("name") %>, you have login as a guest</h1>
	<p>you can wether choose to book a hotel or make a rate<p>
	
	<form action="book" method="post">
	<button type="submit">book</button>
	</form>
	
	<form action="rate" method="post">
	<button type="submit">rate</button>
	</form>

	
</body>
</html>