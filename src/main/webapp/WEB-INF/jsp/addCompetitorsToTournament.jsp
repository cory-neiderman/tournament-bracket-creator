
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
	
	<body id="body1">
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			  	<c:url value="/addTeams" var="addTeams">
						<c:param name="tournamentId" value="${tournament.tournamentId}"/>
					</c:url>
			  	<form action="${addTeams}" method="POST" id="enterTeamsForm">
			  	<input type = "hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
			    	<h3 id="addCompetitiors"class="panel-title">{ Add Competitors }</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form accept-charset="UTF-8" role="form">
			    	
			    	  <c:forEach var="counter" begin="1" end="${maxTeams}">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Competitor Name" name="competitorName" type="text">
			    		</div>
			    	</c:forEach>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="{ Submit }" id="submit">
			    		<div style="color:red">${teamError}</div>
			    	</fieldset>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
<br/>
<br/>
<br/>
<br/>

</body>
</html>
	<!-- 
		<c:url value="/addTeams" var="addTeams">
			<c:param name="tournamentId" value="${tournament.tournamentId}"/>
		</c:url>
    	<c:forEach var="counter" begin="1" end="${maxTeams}">
    		Competitor <c:out value="${counter}"/> Name: <input type="text"  name="competitorName"><br>
    	</c:forEach>
  -->