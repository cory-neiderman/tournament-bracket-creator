<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
   		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
   
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
        <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
        <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <c:url var="cssHref" value="/css/site.css" />
        <link rel="stylesheet" type="text/css" href="${cssHref}">
        
        <script type="text/javascript">
        
            $(document).ready(function() {
               
                
                $("#logoutLink").click(function(event){
                    $("#logoutForm").submit();
                });
                
               
                
            });
            
            
        </script>
    <body>
     
        <header>
            <img src="http://blog.flamingtext.com/blog/2016/04/20/flamingtext_com_1461173830_241360371.png" width="100%" height="270"/>
        </header>
            <div class="container-fluid" >
                <ul class="nav navbar-nav">
                    <c:if test="${not empty user}">
                        <c:url var="dashboardHref" value="/users/${user}" />
                    </c:if>
                </ul>
                
                    <c:choose>
                        <c:when test="${empty user}">
                        <ul class="nav navbar-nav navbar-right">
                          <c:url var="homepageHref" value="/homepage" />
                   			<li class="navButtons"><a href="${homepageHref}">Home</a></li>
                   			<c:url var="loginHref" value="/" />
							<li class="navButtons"><a href="${loginHref}">Log In</a></li>
                            <c:url var="signUpHref" value="/signUp" />
                            <li class="navButtons"><a href="${signUpHref}">Sign Up</a></li>
                                  </ul>
                        </c:when>
                  
                       
                        <c:when test="${user.userRole eq 'host'}">
                        	<ul class="nav navbar-nav navbar-left">
                          <c:url var="createTournamentHref" value="/createTournament" />
                            <li><a href="${createTournamentHref}">Tournament Creator</a></li>
                        	  <c:url var="selectTournamentForAddingCompetitorsHref" value="/selectTournamentForAddingCompetitors" />
                            <li><a href="${selectTournamentForAddingCompetitorsHref}">Add Teams</a></li>
                        	  <c:url var="scheduleMatchesHref" value="/scheduleMatches" />
                            <li><a href="${scheduleMatchesHref}">Scheduler</a></li>
                        	  <c:url var="recordResultsHref" value="/selectTournamentForAddingResults" />
                            <li><a href="${recordResultsHref}">Track Results</a></li>
                         </ul>
                       		<c:url var="logoutAction" value="/logout" />
                            <form id="logoutForm" action="${logoutAction}" method="POST"></form>
                            <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
                            
                              <ul class="nav navbar-nav navbar-right">
                              	<c:url var="tournamentDetailsHref" value="/displayAllTournaments" />
                            	<c:url var="homepageHref" value="/homepage" />
                   					<li><a href="${homepageHref}">Home</a></li>
                            		<li><a href="${tournamentDetailsHref}">Select Tournament to View</a></li>
                            		<li><a id="logoutLink" href="#">Log Out</a></li>
                        </ul>
                        </c:when>
                        <c:otherwise>
                        	
                            	<c:url var="logoutAction" value="/logout" />
                            <form id="logoutForm" action="${logoutAction}" method="POST"></form>
                            <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
                            
                              <ul class="nav navbar-nav navbar-right">
                              	<c:url var="tournamentDetailsHref" value="/displayAllTournaments" />
                            	<c:url var="homepageHref" value="/homepage" />
                   					<li><a href="${homepageHref}">Home</a></li>
                            		<li><a href="${tournamentDetailsHref}">Select Tournament to View</a></li>
                            		<li><a id="logoutLink" href="#">Log Out</a></li>
                        </ul>
                        		
                        </c:otherwise>
                    </c:choose>
            </div>
        </nav>