<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<c:url var="cssHref" value="/css/site.css" />
		<link type="text/css" rel="stylesheet" href="${cssHref}"/>
	<header><img id="logo"img src="http://blog.flamingtext.com/blog/2016/04/19/flamingtext_com_1461026267_370071663.png"/><br/>
	</header>
	<title>Login</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<form id="login" action="login" method="POST">
		<h1>--Login--</h1><br/>
		<br/>
    		<div2> Username : <input type="text" name="username"><br/>
    		<br/>
    		Password : <input type="password" name="password"><br/>
    		<br/> </div2>
    	
    		<input type="submit" value="Login"><br/>
    		
    		<div class="background"><img src="img/brackets.png" ></div>
		
		</form>
		<a href="signUp">Sign Up</a>
	</body>
</html>