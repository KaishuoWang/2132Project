<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Failed</title>
</head>
<body>
	<h1>login failed</h1>
	<h3><%=request.getParameter("name") %>, please check your ID or password.</h3>
	<a href="javascript:history.go(-1);">Try Again</a>
</body>
</html>