
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
		
		
	<html>
</head>
	<body>
	<div class="tournamentDetails">
		<h1 id="verify">Verify Tournament</h1><br/>
		<ul id="tournamentDetails">
			<li id="tournamentDetails"><strong>Tournament Name: </strong><c:out value="${tournament.tournamentName}" />
			<li id="tournamentDetails"><strong>Sport: </strong><c:out value="${tournament.sport}" />
			<li id="tournamentDetails"><strong>Number of Teams: </strong><c:out value="${tournament.maxTeams}" />
			<li id="tournamentDetails"><strong>Start Date: </strong><c:out value="${tournament.startDateAsString}" />
			<li id="tournamentDetails"><strong>End Date: </strong><c:out value="${tournament.endDateAsString}" />
		</ul>
		<br/>
		
	<form id="confirmTournament" action="confirmTournament" method="POST" >
	<input class="btn btn-block btn-lg btn-warning" type="submit" value="{ Confirm Tournament }">
	
				<br/>
				</form>
				</div>
	
</body>
</html>