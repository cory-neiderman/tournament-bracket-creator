<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
	<header><img id="logo"img src="http://blog.flamingtext.com/blog/2016/04/19/flamingtext_com_1461026267_370071663.png"/><br/>
	</header>
			<title>Add Teams To Tournament</title>
			<c:url var="cssHref" value="/css/site.css" />
			<link type="text/css" rel="stylesheet" href="${cssHref}"/>
	</head>
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