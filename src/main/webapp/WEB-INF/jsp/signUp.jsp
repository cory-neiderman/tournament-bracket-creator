<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        
    <c:import url="/WEB-INF/jsp/header.jsp" />
    

        
<c:url var="pwValidationSrc" value="/passwordValidation.js" />
<script src="${pwValidationSrc}"></script>
<script type="text/javascript">
    $(document).ready(function () {
        
    
        $("form").validate({
            rules : {
                password : {
                    required : true,
                    minlength : 8,
                    maxlength : 128,
                    complexPassword : true,
                    noMoreThan2Duplicates : true
                },
                userName : {
                    required : true,
                    minlength: 3,
                    maxlength: 12
                },
                confirmPassword : {
                    required : true,        
                    equalTo : "#password"  
                }
            },
            messages : {            
                confirmPassword : {
                    equalTo : "Passwords do not match"
                },
                userName:{
                    minlength: "username must be at least 3 characters",
                    maxlength: "username is too long.  Maximum length is 12 characters."
                }
            },
            errorClass : "error"
        });
        
$("#userName").change(function() {
            
            var applicationURL = "http://localhost:8080/capstone/signUp/";
            var userName=$("#userName").val();
            
            
            $.ajax({
                url : applicationURL+userName,
                type : "GET",
                dataType : "json"
            }).success(function(result) {
            	 searchForUserName(result);
            }).fail(function(xhr, status, errorMessage) {
                console.log(errorMessage);
                console.log(status);
                console.log(xhr);
                console.log("FAIL");
                
            });
            
            
            });
			function searchForUserName(nameSearchResult){
	       
	        	
	            $("#nameSearch").replaceWith(nameSearchResult[0]);
	               
	        }
        
    });
</script>
<body>
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                <form id="signUp" action="newUserSignUp" method="POST">
                <input type = "hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
                    <h3 id="sign"class="panel-title">Create A {BRAKIT} Account</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Create Username" id="userName" name="userName" type="text">
                        	<div id="nameSearch"></div>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Create Password" name="password" type="password" >
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Confirm Password" name="confirmPassword" type="password" >
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="role" type="checkbox" value="host" > Host
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="role" type="checkbox" value="player"> Player
                            </label>
                        </div>
                        <input class="btn btn-lg btn-danger btn-block" type="submit" value="{ Sign Up }">
                        <div style="color:red">${signUpError}</div>
                    </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
        
        <c:url var = "loginPage" value="/"/>
        <p>
            <a href="${loginPage}">Login here if already a user</a>
        </p>
                <div class="col-sm-6">
                <br/>
                <br/>
                <br/>
            <strong>Password Rules:</strong>
            <ul>
                <li>Must be at least 8 characters long</li>
                <li>Must contain at least 3 of the following 4 types of characters:
                    <ol>
                        <li>Uppercase letter (A-Z)</li>
                        <li>Lowercase letter (a-z)</li>
                        <li>Number (0-9)</li>
                        <li>A "special" character (#, $, space, etc)</li>
                    </ol>
                </li>
                <li>No more than two identical characters in a row</li>
            </ul>
        </div>
    </div>
</form>
        
        
</body>
</html>