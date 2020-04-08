<%@page import="classes.Property"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="submit" method="post">
	<h1>This is the Hotel that you can book</h1>
	<%!DBHandler dbHandler = new DBHandler();%>
	<% ArrayList<Property> result = dbHandler.getAllProperty();%>
	<%for(int i = 0; i < result.size(); i++){%>
		<h4>Property ID:
		<%=result.get(i).getPropertyID()%><br>
		Hotel Price:
		<%=result.get(i).getPrice() + " Street:" + result.get(i).getStreet() + ",  City:" + result.get(i).getCity() + ",  Province:" + result.get(i).getProvince() + ", Country:" + result.get(i).getCountry() + ", available date:" + result.get(i).getAvailableDate()%></h4><br>
	<%} %><br>
	PropertyID: <input type="text" name="id" id="id"><br>
	<button type="submit">submit</button>
	<button type="reset">Reset</button>
	<p>Please remember the Property Id in order to book the Hotel.<p>
</form>
</body>
</html>