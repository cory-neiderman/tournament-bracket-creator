
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
		
	

</head>
	<body >
	<br/>
	<div id="tournamentList">
		<h1 id="selectTournament">{ Select a Tournament }</h1>
		<br/>
		<br/>
		<br/>
		
    <ul>
    <c:forEach var="tournament" items="${tournamentList}">
    	<li id="tournamentLinks">
    	<c:url value="/addCompetitorsToTournament" var="addTeams">
			<c:param name="tournamentId" value="${tournament.tournamentId}" />
		</c:url>
    		<a id="tournamentLinks" href="${addTeams}">{ <c:out value="${tournament.tournamentName}"/> }</a>
    	
    	</c:forEach>
    </ul>
    <br/>
    <br/>
    <br/>
    </div>
    <br/>
       <p align="center"  id="disclaimer">EARLY ACCESS DISCLAIMER</p>
	        <br/>
			<p align="center"  id="disclaimerText">The service is currently for testing purposes. Functionality and features may drastically change, and created content may not be available later. Your feedback is much appreciated!</p><br/>
    <br/>
	</body>
</html>