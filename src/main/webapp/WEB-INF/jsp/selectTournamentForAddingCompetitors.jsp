<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Add Competitors To Tournament</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
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