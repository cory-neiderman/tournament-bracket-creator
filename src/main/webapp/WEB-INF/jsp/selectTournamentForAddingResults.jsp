
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
	
		
	

	<title>{ Add Results To A Tournament }</title>
</head>
	<body>
		<br/>
		<div id="tournamentList">
		<br/>
		<h1 id="selectTournament">{ Add Results To A Tournament }</h1>
		<br/>
		<br/>
		<br/>
    <ul>
    <c:forEach var="tournament" items="${tournamentList}">
    	<li id="tournamentLinks">
    	<c:url value="/selectGameToAddResults" var="selectGameToAddResults">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
    		<a id="tournamentLinks" href="${selectGameToAddResults}">{ <c:out value="${tournament.tournamentName}"/> }</a>
    	
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