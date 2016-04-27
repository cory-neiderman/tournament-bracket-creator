
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
		
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
	    
	    <c:url var="cssHref" value="/css/site.css" />
		<link rel="stylesheet" type="text/css" href="${cssHref}">
	    
		
	<script type="text/javascript">	
		$(document).ready(function(){
  $(document).mousemove(function(e){
     TweenLite.to($('body'), 
        .5, 
        { css: 
            {
                backgroundPosition: ""+ parseInt(event.pageX/8) + "px "+parseInt(event.pageY/'12')+"px, "+parseInt(event.pageX/'15')+"px "+parseInt(event.pageY/'15')+"px, "+parseInt(event.pageX/'30')+"px "+parseInt(event.pageY/'30')+"px"
            }
        });
  });
});
</script>
		
<br/>		
<br/>
<br/><p align="center"  id="followAnd">FOLLOW AND HOST TOURNAMENTS</p><br/>
<br/>
	 <p  align="center" id="live">Live in minutes: set up new tournament, share to spectators and organizers, and publish results as they come.</p>
	<br/>
	<div>
	
	<br/>
		<a href="signUp" class="btn btn-block btn-lg btn-danger">{ Create an Account }</a><br/>
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			  	<form id="login" action="login" method="POST">
			  	<input type = "hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
			    	<h3 id="signIn"class="panel-title">{ Sign In }</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form accept-charset="UTF-8" role="form">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Username" name="username" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Password" name="password" type="password" >
			    		</div>
			    		<div class="checkbox">
			    	    	<label>
			    	    		<input name="remember" type="checkbox" value="Remember Me"> Remember Me
			    	    	</label>
			    	    </div>
			    		<input class="btn btn-lg btn-warning btn-block" type="submit" value="{ Login }">
			    		<div style="color:red">${error}</div>
			    	</fieldset>
			    	<br/>
			      	</form>
			    </div>
			</div>
		</div>
	</div>
</div>
		
	<br/>	
	</div>
	
	
	        <p align="center"  id="disclaimer">EARLY ACCESS DISCLAIMER</p>
	        <br/>
			<p align="center"  id="disclaimerText">The service is currently for testing purposes. Functionality and features may drastically change, and created content may not be available later. Your feedback is much appreciated!</p><br/>
<br/>
<br/>
<br/>


	</body>
</html>