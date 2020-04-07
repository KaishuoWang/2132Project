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
		function validateDelete() {
			var propertyID = document.getElementById("propertyIDDelete").value;
			if (propertyID == "") {
				alert("Your property id cannot be empty");
				return false;
			}
			return true;
		}
	</script>

	<%!DBHandler dbHandler = new DBHandler(); %>
	<h1>Welcome <%=request.getParameter("name") %>, you have login as an employee</h1>
	<%ArrayList<Property> properties = dbHandler.getAllProperty(); %>
	
	<h3>Properties list:</h3>
	
	<%for(int i = 0; i < properties.size(); i++){%>
		<h4>Property ID:
		<%=properties.get(i).getPropertyID()%><br>
		Property Address:
		<%=properties.get(i).getHouseNum() + " " + properties.get(i).getStreet() + ", " + properties.get(i).getCity() + ", " + properties.get(i).getProvince() + ", " + properties.get(i).getCountry() + ", " + properties.get(i).getAvailable() %></h4><br>
	<%} %>
	
	<%
		int count = 0;
		for(int i = 0; i < properties.size(); i++){
			if(!properties.get(i).getAvailable()){
				count += 1;
			}
		}
		float occupancyRate = ((float)count / (float)properties.size()) * 100;
	%>
	
	<h4>
		There are <%=String.valueOf(count) + " (" + Float.toString(occupancyRate) + "%)" %> currently unavailable.
	</h4>
	
	<form action="deleteProperty" method="post">
		<h3>You can delete a property here:</h3>
		Property ID: <input type="text" name="propertyIDDelete" id="propertyIDDelete"><br><br>
		<button type="submit" onclick="return validateDelete();">remove</button>
		<button type="reset">Reset</button>
	</form>
	
	<%dbHandler.closeDB(); %>
</body>
</html>