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
		
	
	
	
	
	<body id="body1">
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			  	<form id="newTournament" action="newTournament" method="GET">
			  	<input type = "hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
			    	<h3 id="createYourTournament"class="panel-title">{ Create Your Tournament }</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form accept-charset="UTF-8" role="form">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Tournament Name" name="tournamentName" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Sport" name="sport" type="text" >
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Number Of Teams" name="numberOfTeams" type="text" >
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Start Date" name="startDate" type="text" >
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="End Date" name="endDate" type="text" >
			    		</div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="{ Submit Tournament }" id="submit">
			    		<div style="color:red">${error}</div>
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


</body>
</html>
