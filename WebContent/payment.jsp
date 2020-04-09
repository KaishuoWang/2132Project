<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paying</title>
</head>
<body>
	<script type="text/javascript">
		function validate() {
			var paymentID = document.getElementById("paymentID");
			var hostID = document.getElementById("hostID");
			var paymentType = document.getElementById("paymentType");
			var amount = document.getElementById("amount");
			var status = document.getElementById("status");
			if (paymentID.value == "") {
				alert("Your payment id cannot be empty");
				return false;
			}
			if (hostID.value == "") {
				alert("Your host ID cannot be empty");
				return false;
			}
			if (paymentType.value == "") {
				alert("Your payment type cannot be empty");
				return false;
			}
			if (amount.value == "") {
				alert("Your amount cannot be empty");
				return false;
			}
			if (status.value == "") {
				alert("Your status cannot be empty");
				return false;
			}
			return true;
		}
	</script>

	<form action="finishPayment" method="post">
		<h1>Make a purchase</h1>
		paymentID: <input type="text" name="paymentID" id="paymentID"><br><br>
		hostID: <input type="text" name="hostID" id="hostID"><br><br>
		paymentType: <input type="text" name="paymentType" id="paymentType"><br><br>
		amount: <input type="text" name="amount" id="amount"><br><br>
		status: <input type="text" name="status" id="status"><br><br>
		<button type="submit" onclick="return validate();">Finish</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>