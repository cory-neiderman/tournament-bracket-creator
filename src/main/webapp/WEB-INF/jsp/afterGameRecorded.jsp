	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
	<c:import url="/WEB-INF/jsp/header.jsp" />
	
		<br/>	
	<html>
	<body class="resultsAftermath">
	
	<br/>
	<br/>
		<h1 id="verifyRseults">{ Match Recorded }</h1><br/>
		<br/>
		<br/>
		<br/>
		<br/>
				<br/>
				<br/><c:url value="/selectGameToAddResults" var="selectGameToAddResults">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
				<a href="${selectGameToAddResults}" class="btn btn-block btn-lg btn-danger">{ Record Another Game }</a><br/>
				<br/>
				<br/><c:url value="/displayTournamentBracket" var="displayTournament">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
			</c:url>
				<a href="${displayTournament}" class="btn btn-block btn-lg btn-danger">{ Back to Tournament }</a><br/>
	
				<br/>
				<br/>
				<br/>
				<br/>
				
	
</body>
<br/>
</html>
<!--  	
	<c:url value="/selectGameToAddResults" var="selectGameToAddResults">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
    	<a id="links" href="${selectGameToAddResults}">Record another game</a>
    	
    	<br>
    	<c:url value="/displayTournamentBracket" var="displayTournament">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
    	
	
		<a id="links" href="${displayTournament}">View tournament</a>
	
</body>

</html>-->