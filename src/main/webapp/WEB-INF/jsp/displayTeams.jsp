
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
		
	
			<body>
              <div class="row">
   <div class="col-md-4">
       <table class="table-condensed" style="width:100%">
         <tr>
           <td class="col-md-5"><div class="input-group"><div class="form-control">Team 1</div><span class="input-group-addon"><span class="badge pull-right">1</span></span></div></td>
           <td class="col-md-2" rowspan="2">L</td>
           <td class="col-md-5" rowspan="2"><div class="input-group"><div class="form-control">Team 1</div><span class="input-group-addon"><span class="badge pull-right">0</span></span></div></td>
         </tr>
         <tr>
           <td><div class="input-group"><div class="form-control">Team 2</div><span class="input-group-addon"><span class="badge pull-right">0</span></span></div></td>
         </tr>
       </table>
   </div>
 </div>
        
        <c:out value="${allCompetitors}"/>
    </body>
</html>
</html>