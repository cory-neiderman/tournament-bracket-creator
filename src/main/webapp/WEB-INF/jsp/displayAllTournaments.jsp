
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
		

<div id="tournamentList">
	<br/>
	<br/>

	<h1 id="selectTournament">{ Select a Tournament }</h1>
	<br/>
    <ul>
    <c:forEach var="tournament" items="${tournamentList}">
    	<li id="tournamentLinks">
    	<c:url value="/displayTournamentBracket" var="displayTournament">
    		<a href="${displayTournament}" class="btn btn-info" role="button">${tournament.tournamentId}</a>
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
    		<a id="tournamentLinks" href="${displayTournament}">{ <c:out value="${tournament.tournamentName}"/> }</a>
    	
    	</li>
    		
    	
    	</c:forEach>
    </ul>
    </div>
    <br/>
       <p align="center"  id="disclaimer">EARLY ACCESS DISCLAIMER</p>
	        <br/>
			<p align="center"  id="disclaimerText">The service is currently for testing purposes. Functionality and features may drastically change, and created content may not be available later. Your feedback is much appreciated!</p><br/>
	</body>
	<br/>
</html>