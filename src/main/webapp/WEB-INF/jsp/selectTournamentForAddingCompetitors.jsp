
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
		
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <c:url var="cssHref" value="/site.css" />
		<link rel="stylesheet" type="text/css" href="${cssHref}">
		
	
<head>
	<title>Add Competitors To Tournament</title>
</head>
	<body>
		<h1>Select a Tournament to Add Competitors To</h1>
    <ul>
    <c:forEach var="tournament" items="${tournamentList}">
    	<li>
    	<c:url value="/addCompetitorsToTournament" var="addTeams">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
    		<a href="${addTeams}"><c:out value="${tournament.tournamentName}"/></a>
    	</li>
    		<c:out value="${tournament.tournamentId}"/>
    	<li>
    	
    	</c:forEach>
    </ul>
	</body>
</html>