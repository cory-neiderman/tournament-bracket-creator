
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
		

		
	 <br/>
	 <br/>
	  <br/>
	   <br/>
	<div class="bracketBack">
	<main id="tournament">
    <c:forEach var="round" items="${roundList}" >
    
    	
	<ul class="round round" >		
	
		<c:forEach var="game" items = "${round.gamesInRound}" >
		
			<li class="spacer">&nbsp;</li>
			<li id="player" class="game game-top ">{ <c:out value="${game.competitor1Name}"/> }<span><c:out value="${game.competitor1Score}"/></span></li>
			<li class="game game-spacer"> game ${game.gameNumber}&nbsp;</li>
			<li id="player" class="game game-bottom ">{ <c:out value="${game.competitor2Name}"/> }<span><c:out value="${game.competitor2Score}"/></span></li>
			<li class="spacer">&nbsp;</li>
    	
    	</c:forEach>
    </ul>
    	</c:forEach>
    	</main>
    	
    	${championName}
    	<br/>
    	<br/>
    
 
</div>
<br/>
   <p align="center"  id="disclaimer">EARLY ACCESS DISCLAIMER</p>
	        <br/>
			<p align="center"  id="disclaimerText">The service is currently for testing purposes. Functionality and features may drastically change, and created content may not be available later. Your feedback is much appreciated!</p><br/>
 
 
 
 
	</body>
</html>