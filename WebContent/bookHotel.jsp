<%@page import="classes.Property"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book hotel</title>
</head>
<body>
	<script type="text/javascript">
		function validate() {
			var propertyID = document.getElementById("id").value;
			var guestID = document.getElementById("guestID").value;
			if (propertyID == "") {
				alert("Your property id cannot be empty");
				return false;
			}
			if (guestID == "") {
				alert("Your guest id cannot be empty");
				return false;
			}
			return true;
		}
	</script>
<form action="submit" method="post">
	<h1>This is the Hotel that you can book</h1>
	<%!DBHandler dbHandler = new DBHandler();%>
	<%ArrayList<Property> result = dbHandler.getAllProperty();%>
	<%for(int i = 0; i < result.size(); i++){%>
		<h4>Property ID:
		<%=result.get(i).getPropertyID()%><br>
		Hotel Price:
		<%=result.get(i).getPrice() + " Street:" + result.get(i).getStreet() + ",  City:" + result.get(i).getCity() + ",  Province:" + result.get(i).getProvince() + ", Country:" + result.get(i).getCountry() + ", available date:" + result.get(i).getAvailableDate()%></h4><br>
	<%} %><br>
	PropertyID: <input type="text" name="id" id="id"><br>
	Your ID: <input type="text" name="guestID" id="guestID"><br>
	<button type="submit" onclick="return validate();">book</button>
	<button type="reset">Reset</button>
	<p>Please remember the Property Id in order to book the Hotel.<p>
	dbHandler.close();
</form>
</body>
</html>