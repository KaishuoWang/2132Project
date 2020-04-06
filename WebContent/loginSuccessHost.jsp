<%@page import="classes.Property"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
	<%! DBHandler dbHandler = new DBHandler();%>
	
	<script type="text/javascript">
		function validate() {
			var hostID = document.getElementById("hostID");
			if(!dbHandler.findHost(hostID.value)){
				alert("Your hostID is wrong");
				return false;
			}
			var propertyID = document.getElementById("propertyID");
			if(!dbHandler.findHost()){
				alert("Your hostID is wrong");
				return false;
			}
			if (name.value == "") {
				alert("Your name cannot be empty");
				return false;
			}
			if (password.value == "") {
				alert("Your password cannot be empty");
				return false;
			}
			return true;
		}
	</script>

	<h1>Welcome <%=request.getParameter("name") %>, you have login as a host</h1>
	
	<% ArrayList<Property> result = dbHandler.getOwnProperties(Integer.parseInt(request.getParameter("id")));%>
	
	<h3>Your property list:</h3>
	
	<%for(int i = 0; i < result.size(); i++){%>
		<h4>Property ID:
		<%=result.get(i).getPropertyID()%><br>
		Property Address:
		<%=result.get(i).getHouseNum() + " " + result.get(i).getStreet() + ", " + result.get(i).getCity() + ", " + result.get(i).getProvince() + ", " + result.get(i).getCountry() %></h4><br>
	<%} %>
	
	<form action="create" method="post">
		<h3>You can add more property here:</h3>
		Your ID: <input type="text" name="hostID" id="hostID"><br><br>
		Property ID: <input type="text" name="propertyID" id="propertyID"><br><br>
		House Number: <input type="text" name="houseNum" id="houseNum"><br><br>
		Street: <input type="text" name="street" id="street"><br><br>
		Province: <input type="text" name="province" id="province"><br><br>
		Country: <input type="text" name="country" id="country"><br><br>
		Room Type: <input type="text" name="roomType" id="roomType"><br><br>
		Price: <input type="text" name="price" id="price"><br><br>
		Available Date: <input type="text" name="date" id="date"><br><br>
		Property Type: <input type="text" name="propertyType" id="propertyType"><br><br>
		Class: <input type="radio" name="class" value="A">A 
				<input type="radio" name="class" value="B">B 
				<input type="radio" name="class" value="C">C<br><br>
		Number of Guest: <input type="text" name="guestNum" id="guestNum"><br><br>
		Amenities: <input type="text" name="amenities" id="amenities"><br><br>
		Rules: <input type="text" name="rules" id="rules"><br><br>
		<button type="submit" onclick="return validate();">create</button>
		<button type="reset">Reset</button>
	</form>
	
</body>
</html>