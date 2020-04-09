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
<title>Booking</title>
</head>
<body>
	<script type="text/javascript">
		function validate() {
			var paymentID = document.getElementById("paymentID");
			var propertyID = document.getElementById("propertyID");
			var guestID = document.getElementById("guestID");
			var startDate = document.getElementById("startDate");
			var endDate = document.getElementById("endDate");
			var signature = document.getElementById("signing");
			if (paymentID.value == "") {
				alert("Your payment id cannot be empty");
				return false;
			}
			if (propertyID.value == "") {
				alert("Your property ID cannot be empty");
				return false;
			}
			if (guestID.value == "") {
				alert("Your guest ID cannot be empty");
				return false;
			}
			if (startDate.value == "") {
				alert("Your start date cannot be empty");
				return false;
			}
			if (endDate.value == "") {
				alert("Your end date cannot be empty");
				return false;
			}
			if (signature.value == "") {
				alert("Your signature cannot be empty");
				return false;
			}
			return true;
		}
	</script>

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
		Signature: <input type="text" name="signing" id="signing"><br><br>
		<button type="submit" onClick="return validate();">Finish</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>