<%@page import="classes.Review"%>
<%@page import="classes.Property"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check property rates</title>
</head>
<body>
	<%!DBHandler dbHandler = new DBHandler();%>
	<% ArrayList<Integer> IDs = new ArrayList<Integer>();
	ArrayList<Float> rates = new ArrayList<>();%>
	<% ArrayList<Property> properties = dbHandler.getOwnProperties(Integer.parseInt(request.getParameter("ownerIDCheck")));%>
	
	<h3>Rate of your properties:</h3>
	
	<%
		for(int i = 0; i < properties.size(); i++){
			IDs.add(properties.get(i).getPropertyID());
		}
		
		for(int i = 0; i < IDs.size(); i++){
			ArrayList<Review> reviews = dbHandler.getReviewByID(IDs.get(i));
			for(int j = 0; j < reviews.size(); j++){
				rates.add((float)reviews.get(i).getRating() / reviews.size());
			}
		}
	%>
	
	<%for(int i = 0; i < IDs.size(); i++){%>
		<h4>Property ID:
		<%=IDs.get(i)%>
		Rate:
		<%=rates.get(i) %></h4><br>
	<%} %>
	<a href="javascript:history.go(-1);">Go Back</a>
</body>
</html>