
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
		
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <c:url var="cssHref" value="/site.css" />
		<link rel="stylesheet" type="text/css" href="${cssHref}">
		
	
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