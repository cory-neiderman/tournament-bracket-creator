<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
<c:import url="/WEB-INF/jsp/header.jsp" />

	<form  action="recordGameScores" method="POST">
		
    		${game.competitor1Name} score: <input type="text" name="competitor1Score"><br/>
    		${game.competitor2Name} score:: <input type="text" name="competitor2Score"><br/>
    		<input type="radio" name="winner" value="competitor1"> ${game.competitor1Name}<br>
  			<input type="radio" name="winner" value="competitor2"> ${game.competitor2Name}<br>
    		<input type="submit" value="Record"><br/>
		
		</form>
		
	</body>
	</html>