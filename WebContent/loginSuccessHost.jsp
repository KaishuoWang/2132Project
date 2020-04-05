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
	<h1>Welcome <%=request.getParameter("name") %>, you have login as a host</h1>
	<%! DBHandler dbHandler = new DBHandler();%>
	<% ArrayList<Property> result = dbHandler.getOwnProperties(Integer.parseInt(request.getParameter("id")));
	System.out.println(result.get(0).getPropertyClass());%>
	
	
	<h3>
	hh
	<%for(int i = 0; i < result.size(); i++){
		result.get(i).getClass();
	} %>
	</h3>
</body>
</html>