
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
		
	
	<body>
		<form id="newTournament" action="newTournament" method="GET">
		<h1>Use this form to create your tournament!</h1><br/>
    		<p><label>Tournament Name: <input type="text" name="tournamentName"><br/></label></p>
    		<P><label>Sport: <input type="text" name="sport"><br/></label></p>
    	    <p><label>Number of Teams Participating: <input type="text" name="numberOfTeams"><br/></label></p>
    		<p><label>Start Date: <input type="text" name="startDate"><br/></label></p>
    		<p><label>End Date: <input type="text" name="endDate"><br/></label></p>
    	
    		<input type="submit" value="Sumbit Tournament" id="submit"><br/>
    		</form>
		
    	
	</body>
</html>