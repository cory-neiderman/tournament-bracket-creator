
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />

	  <br/>
	   <br/>
	   <c:choose>
	   <c:when test="${tournament.championId != ''}"><h1 id="champ">{ <c:out value="${championName}"/> is the Champion of <c:out value="${tournament.tournamentName}"/> }</h1>
	    </c:when>
	    <c:otherwise><c:out value="${tournament.tournamentName}"/></c:otherwise>
	    </c:choose>
		 <br/>
		 <br/>
	
	<div class="bracketBack">
	<main id="tournament">
    <c:forEach var="round" items="${roundList}" >
    
    	
	<ul class="round round" >		
	
		<c:forEach var="game" items = "${round.gamesInRound}" >
		
			<li class="spacer">&nbsp;</li>
			<li id="player" class="game game-top ">
				<c:if test="${game.competitor1Name != 'tba'}">
				{ <c:out value="${game.competitor1Name}"/> }<span><c:out value="${game.competitor1Score}"/>
				</c:if></span>
			</li>
			<li id="gameNumber"class="game game-spacer"> Game ${game.gameNumber}&nbsp;</li>
			<li id="player" class="game game-bottom ">
				<c:if test="${game.competitor2Name != 'tba'}">
				{ <c:out value="${game.competitor2Name}"/> }<span><c:out value="${game.competitor2Score}"/>
				</c:if></span></li>
			<li class="spacer">&nbsp;</li>
    	
    	</c:forEach>
    </ul>
    	</c:forEach>
    	</main>
    
    	<br/>
    	<br/>
    
 
</div>
<br/>
   <p align="center"  id="disclaimer">EARLY ACCESS DISCLAIMER</p>
	        <br/>
			<p align="center"  id="disclaimerText">The service is currently for testing purposes. Functionality and features may drastically change, and created content may not be available later. Your feedback is much appreciated!</p><br/>
 
 
 
 
	</body>
</html>