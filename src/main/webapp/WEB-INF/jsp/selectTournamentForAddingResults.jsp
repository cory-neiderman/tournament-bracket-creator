
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
		
	

	<title>{ Add Results To A Tournament }</title>
</head>
	<body>
		<br/>
		<div id="tournamentList">
		<h1 id="selectTournament">{ Add Results To A Tournament }</h1>
		<br/>
		<br/>
		<br/>
    <ul>
    <c:forEach var="tournament" items="${tournamentList}">
    	<li id="links">
    	<c:url value="/selectGameToAddResults" var="selectGameToAddResults">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
    		<a id="links" href="${selectGameToAddResults}">{ <c:out value="${tournament.tournamentName}"/> }</a>
    	
    	</c:forEach>
    </ul>
       <br/>
    <br/>
    <br/>
    </div>
    <br/>
	</body>
</html>