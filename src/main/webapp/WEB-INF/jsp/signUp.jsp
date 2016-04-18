<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Sign Up</title>
</head>
	<body>
		<form id="newUserSignUp" action="newUserSignUp" method="POST">
		<h1>Create an account to view tournaments</h1>
    		<label for="userName">Enter your Username:</label> <input type="text" name="userName"><br/>
    		<label for="password">Enter your Password: </label> <input type="text" name="password"><br/>
    		<br/>
    		<select name ="role">
			  <option value="player">Player</option>
			  <option value="host">Host</option>
			</select>
    		<input type="submit" value="Sign up"><br/>
		
		</form>
		
		<c:url var = "loginPage" value="/"/>
  		<p>
  			<a href="${loginPage}">Login here if already a user</a>
  		</p>
		
				
				
	</body>
</html>