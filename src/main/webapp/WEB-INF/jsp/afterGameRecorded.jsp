	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
	<c:import url="/WEB-INF/jsp/header.jsp" />
	
	
	
	<h1>Your game has been recorded</h1>
	
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

</html>