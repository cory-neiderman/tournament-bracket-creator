
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
<div class="tournamentDisplay">
	<br/>
	<br/>

	<h1 id="displayTournaments">{ Select a Tournament }</h1>
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