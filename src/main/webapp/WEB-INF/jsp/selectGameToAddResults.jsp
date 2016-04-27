
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
		
	

	<title>Select game to record results</title>
</head>
	<body>
		<h1>Select game to record results</h1>
    <ul>
    <c:forEach var="game" items="${gameList}">
    	<li id="links">
    	<c:url value="/recordGameResults" var="recordGameResults">
			<c:param name="gameId" value="${game.gameId}"/>
		</c:url>
    		<a href="${recordGameResults}"> <c:out value="${game.competitor1Name}"/> vs. <c:out value="${game.competitor2Name}"/></a>
    	
    	</c:forEach>
    </ul>
	</body>
</html>