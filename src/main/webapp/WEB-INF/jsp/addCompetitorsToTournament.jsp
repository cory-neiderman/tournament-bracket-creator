<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Add Teams To Tournament</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		
		<h1>Add Competitors To Tournament</h1>
		<form>
    	<c:forEach var="counter" begin="1" end="${maxTeams}">
    		Competitor Name: <input type="text" name="competitorName"><br>
    	</c:forEach>
    	<input type="submit" value="Submit">
    	</form>
	</body>
</html>