<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function validate() {
			var id = document.getElementById("id");
			var Fname = document.getElementById("Fname");
			var Lname = document.getElementById("Lname");
			var password = document.getElementById("password");
			if (id.value == "") {
				alert("Your id cannot be empty");
				return false;
			}
			if (Fname.value == "") {
				alert("Your first name cannot be empty");
				return false;
			}
			if (Lname.value == "") {
				alert("Your last name cannot be empty");
				return false;
			}
			if (password.value == "") {
				alert("Your password cannot be empty");
				return false;
			}
			return true;
		}
	</script>
	<form action="createNewGuest" method="post">
		<h1>Welcome</h1>
		ID: <input type="text" name="id" id="id"><br><br>
		First Name: <input type="text" name="Fname" id="Fname"><br><br>
		Last Name: <input type="text" name="Lname" id="Lname"><br><br>
		Address: <input type="text" name="address" id="address"><br><br>
		Password: <input type="text" name="password" id="password"><br><br>
		Email Address: <input type="text" name="email" id="email"><br><br>
		Phone Number: <input type="text" name="phoneNum" id="phoneNum"><br><br>
		<button type="submit" onclick="return validate();">Create</button>
		<button type="reset">Reset</button>
	</form>
</body>
</html>