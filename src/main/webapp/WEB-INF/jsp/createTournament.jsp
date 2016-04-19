<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Create A Tournament</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<form id="newTournament" action="newTournament" method="GET">
		<h1>Use this form to create your tournament!</h1><br/>
    		Tournament Name: <input type="text" name="tournamentName"><br/>
    		Sport: <input type="text" name="sport"><br/>
    	    Number of Teams Participating: <input type="text" name="numberOfTeams"><br/>
    		Start Date: <input type="text" name="startDate"><br/>
    		End Date: <input type="text" name="endDate"><br/>
    	
    		<input type="submit" value="Sumbit Tournament"><br/>
    		</form>
		
    	
	</body>
</html>