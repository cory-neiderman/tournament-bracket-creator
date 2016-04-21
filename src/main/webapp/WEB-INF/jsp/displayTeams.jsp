
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
				 <table summary="Tournament Bracket" class="bracket">
					<tr>
						<th>National Semi-Finals<br>Saturday November 8th</th>
					    <th>National Championship<br>Sunday November 9th</th>
					    <th>NJCAA National Champion</th>
					</tr>
					<tr>
    					<td><p>#1 Manchester CC (17-2-1)</p></td>
      				    <td rowspan="2"><p></p></td>
  					    <td rowspan="4"><p></p></td>
      				</tr>
  					<tr>
   						 <td><p>#4 Triton College (13-4-0)</p></td>
					</tr>
					<tr>
  					    <td><p>#2 Herkimer County CC (18-3-0)</p></td>
    					<td rowspan="2"><p></p></td>
					</tr>
					<tr>
   						 <td><p>#3 County College of Morris (17-3-0)</p></td>
					</tr>
				</table>
		
		<c:out value="${allCompetitors}"/>
	</body>
</html>