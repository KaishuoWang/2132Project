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
	<script type="text/javascript">
		function validateInsert() {
			var propertyID = document.getElementById("propertyID").value;
			var houseNum = document.getElementById("houseNum").value;
			var street = document.getElementById("street").value;
			var city = document.getElementById("city").value;
			var province = document.getElementById("province").value;
			var country = document.getElementById("country").value;
			var roomType = document.getElementById("roomType").value;
			var price = document.getElementById("price").value;
			var availableDate = document.getElementById("availableDate").value;
			var propertyType = document.getElementById("propertyType").value;
			var radio = document.getElementsByName("class");
			var Class;
			for (i=0; i<radio.length; i++) {
				if (radio[i].checked) {
					Class = radio[i].value;
				}
			}
			var guestNum = document.getElementById("guestNum").value;
			
			if (propertyID == "") {
				alert("Your propertyID cannot be empty");
				return false;
			}
			if (houseNum.value == "") {
				alert("Your house number cannot be empty");
				return false;
			}
			if (street.value == "") {
				alert("Your street cannot be empty");
				return false;
			}
			if (city.value == "") {
				alert("Your city cannot be empty");
				return false;
			}
			if (province.value == "") {
				alert("Your province cannot be empty");
				return false;
			}
			if (country.value == "") {
				alert("Your country cannot be empty");
				return false;
			}
			if (roomType.value == "") {
				alert("Your room type cannot be empty");
				return false;
			}
			if (price.value == "") {
				alert("Your price cannot be empty");
				return false;
			}
			if (availableDate.value == "") {
				alert("Your available date cannot be empty");
				return false;
			}
			if (propertyType.value == "") {
				alert("Your property type cannot be empty");
				return false;
			}
			if (Class.value == "") {
				alert("Your class cannot be empty");
				return false;
			}
			return true;
		}
		
		function validateDelete() {
			var propertyID = document.getElementById("propertyIDDelete").value;
			if (propertyID == "") {
				alert("Your property id cannot be empty");
				return false;
			}
			return true;
		}
		
		function validateEdit(){
			var propertyID = document.getElementById("propertyIDEdit").value;
			var amenities = document.getElementById("amenitiesEdit").value;
			var rules = document.getElementById("rulesEdit").value;
			var availableDate = document.getElementById("availableDateEdit").value;
			if (propertyID == "") {
				alert("Your property id cannot be empty");
				return false;
			}
			if (amenities == "" && rules == "" && availableDate == "") {
				alert("Your have to fill one fo rule, amenity, available date");
				return false;
			}
			return true;
		}
	</script>
	
	<%! DBHandler dbHandler = new DBHandler();%>

	<h1>Welcome <%=request.getParameter("name") %>, you have login as a host</h1>
	
	<% ArrayList<Property> result = dbHandler.getOwnProperties(Integer.parseInt(request.getParameter("id")));%>
	
	<h3>Your property list:</h3>
	
	<%for(int i = 0; i < result.size(); i++){%>
		<h4>Property ID:
		<%=result.get(i).getPropertyID()%><br>
		Property Address:
		<%=result.get(i).getHouseNum() + " " + result.get(i).getStreet() + ", " + result.get(i).getCity() + ", " + result.get(i).getProvince() + ", " + result.get(i).getCountry() %></h4><br>
	<%} %>
	
	<form action="editPropertyA&R" method="post">
		<h3>You can edit amenities and rules here:</h3>
		Property ID: <input type="text" name="propertyIDEdit" id="propertyIDEdit"><br><br>
		Amenities: <input type="text" name="amenitiesEdit" id="amenitiesEdit"><br><br>
		Rules: <input type="text" name="rulesEdit" id="rulesEdit"><br><br>
		Available Date: <input type="text" name="availableDateEdit" id="availableDateEdit"><br><br>
		<button type="submit" onclick="return validateEdit();">Edit</button>
		<button type="reset">Reset</button>
	</form>
	
	<form action="createProperty" method="post">
		<h3>You can add more property here:</h3>
		Your ID: <input type="text" name="ownerID" id="ownerID"><br><br>
		Property ID: <input type="text" name="propertyID" id="propertyID"><br><br>
		House Number: <input type="text" name="houseNum" id="houseNum"><br><br>
		Street: <input type="text" name="street" id="street"><br><br>
		City: <input type="text" name="city" id="city"><br><br>
		Province: <input type="text" name="province" id="province"><br><br>
		Country: <input type="text" name="country" id="country"><br><br>
		Room Type: <input type="text" name="roomType" id="roomType"><br><br>
		Price: <input type="text" name="price" id="price"><br><br>
		Available Date:(yyyy-mm-dd) <input type="text" name="availableDate" id="availableDate"><br><br>
		Property Type: <input type="text" name="propertyType" id="propertyType"><br><br>
		Class: <input type="radio" name="class" value="A">A 
				<input type="radio" name="class" value="B">B 
				<input type="radio" name="class" value="C">C<br><br>
		Number of Guest: <input type="text" name="guestNum" id="guestNum"><br><br>
		Amenities: <input type="text" name="amenities" id="amenities"><br><br>
		Rules: <input type="text" name="rules" id="rules"><br><br>
		<button type="submit" onclick="return validateInsert();">create</button>
		<button type="reset">Reset</button>
	</form>
	
	<form action="deleteProperty" method="post">
		<h3>You can delete a property here:</h3>
		Property ID: <input type="text" name="propertyIDDelete" id="propertyIDDelete"><br><br>
		<button type="submit" onclick="return validateDelete();">remove</button>
		<button type="reset">Reset</button>
	</form>
	<%dbHandler.closeDB(); %>
</body>
</html>