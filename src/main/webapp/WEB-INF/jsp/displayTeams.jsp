<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Add Teams To Tournament</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		
		<c:out value="${allCompetitors}"/>
	</body>
</html>