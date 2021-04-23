<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
 body {
	background-image: url("/ORS_0/resources/img/background.jpg");
    background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
} 
</style>
</head>

<body>
<sf:form  modelAttribute="form" method="post">
<div class="container-fluid" align="center"  >

<aside class="col-sm-4">

<div class="card"  align="center">
<article class="card-body">



	<h4 class="card-title text-center mb-4 mt-1" style="color: #C71585;"><s:message code="label.changepassword"></s:message></h4>
	<hr>
	
	
  <c:if test="${success != null}">
  <div class="alert alert-success alert-dismissible fade show">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <b>${success}</b>
  </div>
  </c:if>
 
 <c:if test="${error != null}">
   <div class="alert alert-danger alert-dismissible fade show">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
     <b>${error}</b>
  </div>
  </c:if>
  
   <sf:hidden path="id" />
				<sf:hidden path="createdBy" />
				<sf:hidden path="modifiedBy" />
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
    
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.oldPassword" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i></span></div>
		 
  <sf:label path="oldPassword">
					
					<c:set var="oldPasswordErrors">
						
					</c:set>
					<c:if test="${not empty oldPasswordErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('toldPassword')"
							onmouseout="hideError('toldPassword')"></i>
					</c:if>
						</sf:label>
				<sf:input path="oldPassword" class="form-control"
					placeholder="${enteroldpassword}" />

	
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="oldPassword" /></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.newPassword" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i> </span></div>
		 
    <sf:label path="newPassword">
					
					<c:set var="newPasswordErrors">
						
					</c:set>
					<c:if test="${not empty newPasswordErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tnewPassword')"
							onmouseout="hideError('tnewPassword')"></i>
					</c:if>
						</sf:label>
				<sf:input type="newPassword" path="newPassword" class="form-control"
					placeholder="${enternewpassword}" />
					
			
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="newPassword"/></font></div>
	
	</div>
	
	<div class="form-group">
			
    <div align="left" style="color:#8A2BE2; " for="validationDefault02"><s:message code="label.confirmPassword" /><span style="color: red">*</span></div>
	<div class="input-group">
    <div class="input-group-prepend">
    <span class="input-group-text"> <i class="fas fa-user"></i> </span></div>
		 
   <sf:label path="confirmPassword">${error1}
					
					<c:set var="confirmPasswordErrors">
						
					</c:set>
					<c:if test="${not empty confirmPasswordErrors}">
						<i class="fa fa-exclamation-circle text-danger"
							onmouseover="showError('tconfirmPassword')"
							onmouseout="hideError('tconfirmPassword')"></i>
					</c:if>
							</sf:label>
				<sf:input type="password" path="confirmPassword" class="form-control"
					placeholder="${enterconPassword}" />	
					
	</div>
	<div align="left"><font style="color: red" ><sf:errors path="confirmPassword"/></font></div>
	
	</div>
	
	
	<button type="submit" name="operation"  value="save" style="float: left;width: 100px;" class="btn btn-primary btn-block button2" ><s:message code="label.save"/> </button>
	<button type="submit" name="operation"  value="Cancel" style="width:150px;margin-left: 150px;" class="btn btn-primary btn-block button2 msgBtn" ><s:message code="label.myprofile"/></button>
		 
	
		 
	 

	
   </article>
</div>

	</aside>
	<br><br><br><br>
</div> 



</sf:form>
</body>
</html>