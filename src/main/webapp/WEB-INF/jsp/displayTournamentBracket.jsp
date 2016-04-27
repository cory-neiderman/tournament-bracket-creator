
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
	 <br/>
	  <br/>
	   <br/>
	<div class="bracketBack">
	<main id="tournament">
    <c:forEach var="round" items="${roundList}" varStatus="count" >
    
    	
	<ul class="round round-1" >		
	
		<c:forEach var="game" items = "${round.gamesInRound}" >
		
			<li class="spacer">&nbsp;</li>
			<li id="player" class="game game-top winner">{ <c:out value="${game.competitor1Name}"/> }<span><c:out value="${game.competitor1Score}"/></span></li>
			<li class="game game-spacer">&nbsp;</li>
			<li id="player" class="game game-bottom ">{ <c:out value="${game.competitor2Name}"/> }<span><c:out value="${game.competitor2Score}"/></span></li>

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