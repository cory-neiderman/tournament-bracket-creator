<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <c:url var="cssHref" value="/site.css" />
		<link rel="stylesheet" type="text/css" href="${cssHref}">
		
<c:url var="pwValidationSrc" value="/passwordValidation.js" />
<script src="${pwValidationSrc}"></script>

<script type="text/javascript">
	$(document).ready(function () {
		
	
		$("form").validate({
			rules : {
				password : {
					required : true,
					minlength : 8,
					maxlength : 128,
					complexPassword : true,
					noMoreThan2Duplicates : true
				},
				userName : {
					required : true,
					minlength: 3,
					maxlength: 12
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"  
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				},
				userName:{
					minlength: "username must be at least 3 characters",
					maxlength: "username is too long.  Maximum length is 12 characters."
				}
			},
			errorClass : "error"
		});
		
		function userNameLookup(name){
			
			
			
		}
		
	});
</script>



<head>
	<title>Sign Up</title>
</head>
<header><img id="logo"img src="http://blog.flamingtext.com/blog/2016/04/19/flamingtext_com_1461026267_370071663.png"/><br/>
	</header>
	
	<body>
		<form action="newUserSignUp" method="POST">
		<h1>Create an account to view tournaments</h1>
    		<label for="userName">Enter your Username:</label> <input type="text"  name="userName" onblur="userNameLookup(this.value)"><br/>
    		<br/>
    		<label for="password">Enter your Password: </label> <input type="password" id="password" name="password"><br/>
    		<br/>
    		<label for="confirmPassword">Confirm your Password: </label> <input type="password" id="confirmPassword" name="confirmPassword"><br/>
    		<br/>
    		<br/>
    		<select name ="role">
			  <option value="player">Player</option>
			  <option value="host">Host</option>
			  <br/>
			</select>
    		<input type="submit" value="Sign up"><br/>
		
		</form>
		
		<div style="color:red">${error}</div>
		
		<c:url var = "loginPage" value="/"/>
  		<p>
  			<a href="${loginPage}">Login here if already a user</a>
  		</p>
  				<div class="col-sm-6">
			<strong>Password Rules:</strong>
			<ul>
				<li>Must be at least 10 characters long</li>
				<li>Must contain at least 3 of the following 4 types of characters:
					<ol>
						<li>Uppercase letter (A-Z)</li>
						<li>Lowercase letter (a-z)</li>
						<li>Number (0-9)</li>
						<li>A "special" character (#, $, space, etc)</li>
					</ol>
				</li>
				<li>No more than two identical characters in a row</li>
			</ul>
		</div>
	</div>
</form>
		
		
				
				
	</body>
</html>