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
		<p>just need one more step!<p><br>
	
		paymentID: <input type="text" name="paymentID" id="paymentID"><br><br>
		hostID: <input type="text" name="hostID" id="hostID"><br><br>
		propertyID: <input type="text" name="propertyID" id="propertyID"><br><br>
		guestID: <input type="text" name="guestID" id="guestID"><br><br>
		amount: <input type="text" name="amount" id="amount"><br><br>
		Start Date:(yyyy-mm-dd:) <input type="text" name="startDate" id="startDate"><br><br>
		End Date:(yyyy-mm-dd:) <input type="text" name="endDate" id="endDate"><br><br>
		Signing: <input type="text" name="signing" id="signing"><br><br>
		<button type="submit">Finish</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>