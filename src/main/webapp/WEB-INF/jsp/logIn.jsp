<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>To Do List</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<form id="login" action="login" method="POST">
		<h1>Login to use your todo list!</h1>
    		Username: <input type="text" name="username"><br/>
    		Password: <input type="password" name="password"><br/>
    		<input type="submit" value="Login"><br/>
		
		</form>
		<a href="signUp">Sign Up</a>
	</body>
</html>