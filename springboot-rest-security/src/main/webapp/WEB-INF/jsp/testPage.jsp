<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page title</title>
</head>
<body>
Hello there... <br/>

<% out.println("your IP address is... "+request.getRemoteAddr()); %>
</body>
</html>