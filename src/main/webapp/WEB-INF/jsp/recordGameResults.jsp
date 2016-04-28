<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		
	<c:import url="/WEB-INF/jsp/header.jsp" />
		

		<br/>
		
		
		
		<body class="resultsAftermath">
		 <br/>
			<h1 id="aftermath">{ Aftermath }</h1>
		
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                <form  action="recordGameScores" method="POST">
                <input type = "hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
                    <h3 id="gameResults"class="panel-title">{ Game Results }</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form">
                    <fieldset>
                        <div class="form-group">
                       
                            <input class="form-control" placeholder=" ${game.competitor1Name} Score" name="competitor1Score" type="text">
                        	<div id="nameSearch"></div>
                        </div>
                          <div class="checkbox">
                            <label>
                           
                                <input name="winnerId" type="radio" value="${game.competitor1}" > Winner?
                            </label>
                            <br/>
                        <div class="form-group">
                                                    <br/>
                        
                            <input class="form-control" placeholder=" ${game.competitor2Name} Score" name="competitor2Score" type="text" >
                        </div>
                        <div class="checkbox">
                            <label>
                           
                                <input name="winnerId" type="radio" value="${game.competitor2}"> Winner?
                            </label>
                        </div>
                        <input class="btn btn-lg btn-danger btn-block" type="submit" value="{ Record }">
                        
                        <div style="color:red">${error}</div>
                    </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
		
    	<!-- ${game.competitor1Name} score: <input type="text" name="competitor1Score"><br/>
    		${game.competitor2Name} score:: <input type="text" name="competitor2Score"><br/>
    		<input type="radio" name="winner" value="competitor1"> ${game.competitor1Name}<br>
  			<input type="radio" name="winner" value="competitor2"> ${game.competitor2Name}<br>
    		<input type="submit" value="Record"><br/>
		
		</form> -->	
		                            <br/>
		                            <br/>
		                            <br/>
		
	</body>
	</html>