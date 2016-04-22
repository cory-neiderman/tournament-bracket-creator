
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
		   
<script type="text/javascript">
    $(document).ready(function () {
        
    
        $("#enterTeamsForm").validate({
            rules : {
                
                competitorName : {
                    required : true,
                    minlength: 3,
                    maxlength: 20
                }
                
            },
            messages : {            
                
                competitorName:{
                    minlength: "competitor name must be at least 3 characters",
                    maxlength: "competitor name is too long.  Maximum length is 20 characters."
                }
            },
            errorClass : "error"
        });
        

        
    });
</script>      
	
	<body>
		
		<h1>Add Competitors To Tournament</h1>
		<div style="color:red">${teamError}</div>
		
		<c:url value="/addTeams" var="addTeams">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
		
		<form action="${addTeams}" method="POST" id="enterTeamsForm">
		
    	<c:forEach var="counter" begin="1" end="${maxTeams}">
    		Competitor <c:out value="${counter}"/> Name: <input type="text"  name="competitorName"><br>
    	</c:forEach>
    		<input type="submit" value="Submit">
    	</form>
	</body>
</html>