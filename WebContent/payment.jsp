<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="finishPayment" method="post">
		<h1>Make a purchase</h1>
		paymentID: <input type="text" name="paymentID" id="paymentID"><br><br>
		hostID: <input type="text" name="hostID" id="hostID"><br><br>
		paymentType: <input type="text" name="paymentType" id="paymentType"><br><br>
		amount: <input type="text" name="amount" id="amount"><br><br>
		status: <input type="text" name="status" id="status"><br><br>
		<button type="submit">Finish</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>