<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<header><img id="logo"img src="http://blog.flamingtext.com/blog/2016/04/19/flamingtext_com_1461026267_370071663.png"/><br/>
	</header>
	<title>Homepage</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<h1>You're Logged In <c:out value="${user.userName}" /></h1>
		
	
	
	<c:if test="${user.userRole eq 'host'}">
			<a href="createTournament">Create Tournament</a><br>
	    	<a href="selectTournamentForAddingCompetitors">Add Team to Existing Tournament</a><br>
	    	<a href="#">Schedule Matches</a><br>
	    	<a href="#">Record Result from a Completed Match</a>
	</c:if>
    
	
	</body>
</html>