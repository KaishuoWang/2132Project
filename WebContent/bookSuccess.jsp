<%@page import="classes.Property"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DBHandler"%>
<%@page import="classes.rentalAgreement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success!</title>
</head>
<body>
	<form action="finish" method="post">
		<h1>almost there!</h1>
		<%!DBHandler dbHandler = new DBHandler();%>
		<%!rentalAgreement rentalAgreement = new rentalAgreement(); %>
		<p>just need one more step!<p><br>
		paymentID:<input type="text" name="paymentID" id="paymentID"><br><br>
		<p>hostID:<%=request.getParameter("guestID")%><br><br></p>
		propertyID: <input type="text" name="propertyID" id="propertyID"><br><br>
		guestID: <input type="text" name="guestID" id="guestID"><br><br>
		<p>amount:<%=dbHandler.getPropertyAmount(Integer.parseInt(request.getParameter("id")))%><br><br>
		Start Date:(yyyy-mm-dd:) <input type="text" name="startDate" id="startDate"><br><br>
		End Date:(yyyy-mm-dd:) <input type="text" name="endDate" id="endDate"><br><br>
		Signing: <input type="text" name="signing" id="signing"><br><br>
		<button type="submit">Finish</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>