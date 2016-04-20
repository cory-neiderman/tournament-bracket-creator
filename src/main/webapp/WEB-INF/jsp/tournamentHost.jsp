<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<header><img id="logo"img src="http://blog.flamingtext.com/blog/2016/04/19/flamingtext_com_1461026267_370071663.png"/><br/>
	</header>
	<title>Tournament Page</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<h1>Welcome to the Tournament Organizer Page <c:out value="${user.userName}" />!</h1>
		
    	<a href="createTournament">Create Tournament</a>
    	<a href="selectTournamentForAddingCompetitors">Add Team to Existing Tournament</a>
    	<a href="#">Schedule Matches</a>
    	<a href="#">Record Result from a Completed Match</a>
   
	</body>
</html>