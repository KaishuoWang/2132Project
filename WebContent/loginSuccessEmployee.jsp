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
	<%!DBHandler dbHandler = new DBHandler(); %>>
	<h1>Welcome <%=request.getParameter("name") %>, you have login as an employee</h1>
	<%ArrayList<Property> properties = dbHandler.getAllProperty(); %>
	
	<h3>Properties list:</h3>
	
	<%for(int i = 0; i < properties.size(); i++){%>
		<h4>Property ID:
		<%=properties.get(i).getPropertyID()%><br>
		Property Address:
		<%=properties.get(i).getHouseNum() + " " + properties.get(i).getStreet() + ", " + properties.get(i).getCity() + ", " + properties.get(i).getProvince() + ", " + properties.get(i).getCountry() %></h4><br>
	<%} %>
	
	<%dbHandler.closeDB(); %>>
</body>
</html>