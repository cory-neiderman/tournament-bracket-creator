
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
		
	

	<title>{ Add Results To A Game }</title>
</head>
<br/>
	<body>
	<div id="tournamentList">
		<br/>
		<h1 id="selectTournament">{ Add Results To A Game }</h1>
		<br/>
		<br/>
		<br/>
    <ul>
    <c:forEach var="game" items="${gameList}">
    	<li id="tournamentLinks">
    	<c:url value="/recordGameResults" var="recordGameResults">
			<c:param name="gameId" value="${game.gameId}"/>
		</c:url>
    		<a id="tournamentLinks" href="${recordGameResults}">{ <c:out value="${game.competitor1Name}"/>   vs.   <c:out value="${game.competitor2Name}"/> }</a>
    	
    	</c:forEach>
    </ul>
     <br/>
    <br/>
    <br/>
    </div>
    <br/>
       <p align="center"  id="disclaimer">EARLY ACCESS DISCLAIMER</p>
	        <br/>
			<p align="center"  id="disclaimerText">The service is currently for testing purposes. Functionality and features may drastically change, and created content may not be available later. Your feedback is much appreciated!</p><br/>
        <br/>
    
	</body>
</html>