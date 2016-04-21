
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
	
	<c:if test="${user.userRole eq 'host'}">
			<a href="createTournament">Create Tournament</a><br>
	    	<a href="selectTournamentForAddingCompetitors">Add Team to Existing Tournament</a><br>
	    	<a href="#">Schedule Matches</a><br>
	    	<a href="#">Record Result from a Completed Match</a>
	</c:if>
    
	
	</body>
</html>