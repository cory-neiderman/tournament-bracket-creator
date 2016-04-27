
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
		
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <c:url var="cssHref" value="/css/site.css" />
		<link rel="stylesheet" type="text/css" href="${cssHref}">
		
<br/>
<br/>
<br/><p align="center"  id="followAnd">FOLLOW AND HOST TOURNAMENTS</p><br/>
	 <p  align="center" id="live">Live in minutes: set up new tournament, share to spectators and organizers, and publish results as they come.</p>
	<br/>
	<br/>
	<br/>
	<div>
	<br/>
		<a href="signUp" class="btn btn-block btn-lg btn-danger">{ Create an Account }</a><br/>
		<br/>
		<c:url value="/" var="loginHref"/>
		<a href="${loginHref}" class="btn btn-block btn-lg btn-warning">{ Sign In }</a>
		<br/>
	<br/>	
	</div>
	        <p align="center"  id="disclaimer">EARLY ACCESS DISCLAIMER</p>
	        <br/>
			<p align="center"  id="disclaimerText">The service is currently for testing purposes. Functionality and features may drastically change, and created content may not be available later. Your feedback is much appreciated!</p><br/>
<br/>
<br/>
<br/>


	</body>
</html>