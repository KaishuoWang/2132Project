<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rating</title>
</head>
<body>
	<script type="text/javascript">
		function validate() {
			var reviewID = document.getElementById("reviewIID");
			var propertyID = document.getElementById("propertyID");
			var rating = document.getElementById("rating");
			if (reviewID.value == "") {
				alert("Your review id cannot be empty");
				return false;
			}
			if (propertyID.value == "") {
				alert("Your property ID cannot be empty");
				return false;
			}
			if (rating.value == "") {
				alert("Your rating cannot be empty");
				return false;
			}
			return true;
		}
	</script>

	<form action="checkIDAva" method="post">
		<h1>Please enter your review thank you</h1>
		Your ID: <input type="text" name="nameID" id="nameID"><br><br>
		Property ID: <input type="text" name="propertyID" id="propertyID"><br><br>
		Rate(1 to 10) :<input type="text" name="rate" id="rate"><br><br>
		Communication: <input type="text" name="communication" id="communication"><br><br>
		Cleanliness: <input type="text" name="cleanliness" id="cleanliness"><br><br>
		Value: <input type="text" name="value" id="value"><br><br>
		<button type="submit" onClick="return validate()">submit</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>