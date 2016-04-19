<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Verify Tournament Creation</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
	
</head>
	<body>
		<h1>Please verify that your tournament details are correct</h1>
		<ul>
			<li><strong>Tournament Name: </strong><c:out value="${tournament.tournamentName}" />
			<li><strong>Sport: </strong><c:out value="${tournament.sport}" />
			<li><strong>Number of Teams: </strong><c:out value="${tournament.maxTeams}" />
			<li><strong>Start Date: </strong><c:out value="${tournament.startDateAsString}" />
			<li><strong>End Date: </strong><c:out value="${tournament.endDateAsString}" />
		</ul>
	<form id="confirmTournament" action="confirmTournament" method="POST">
	<input type="submit" value="Confirm"></form>
	</body>
</html>