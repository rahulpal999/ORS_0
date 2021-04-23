
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="<c:url value="/resources/js/Checkbox11.js"/>" ></script>
	<style type="text/css">
	.navbar-collapse.collapse.show {
  max-height: 50%;
  overflow-y: auto;
}
.btn-group{


 position: fixed;
  z-index: 1;
  
}
.nav-item:hover{
background-color: black;
}
	</style>
</head>

<body>

	<!-- navbar -->

	<nav class="navbar navbar-expand-sm navbar-light fixed-top"
		style="background-color: rgb(0, 102, 255);">
		<a href=""> <img
			src='<c:url value="/resources/img/logo.jpg"></c:url>' width="80px"
			height="30px"></a>&nbsp;
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo03"
			aria-controls="navbarTogglerDemo03" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
			
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link text-light "
					style="font-size: 20px;" href="<c:url value="/Welcome"></c:url>"><i
						class="fas fa-home" style="color: white;"></i></a></li>
				<c:if test="${not empty sessionScope.user}">
					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/User/AddUser"/>"><i
							class="fas fa-user" style="color: orange;"></i> <span
							style="color: white;"><s:message code="label.adduser" /></span></a>

					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Student/AddStudent"/>"><i
							class="fa fa-user-circle" style="color: orange;"></i> <span
							style="color: white;"><s:message code="label.addstudent" />
						</span></a></li>


					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/College/AddCollege"/>"><i
							class="fa fa-university" style="color: orange;"></i> <span
							style="color: white;"><s:message code="label.addcollege" /></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Faculty/AddFaculty"/>"><i
							class='fas fa-chalkboard-teacher' style="color: orange;"></i> <span
							style="color: white;"><s:message code="label.addfaculty" /></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Subject/AddSubject"/>"><i
							class="fa fa-copy" style="color: orange;"></i> <span
							style="color: white;"><s:message code="label.addsubject" /></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Role/AddRole"/>"><i
							class="fa fa-male" style="color: orange;"></i><span
							style="color: white;"><s:message code="label.addrole" /></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/Course/AddCourse"/>"><i
							class="fa fa-book" style="color: orange;"></i> <span
							style="color: white;"><s:message code="label.addcourse" /></span></a>
					</li>

					<li class="nav-item text-nowrap"><a
						class="nav-link text-light " style="font-size: 14px;"
						href="<c:url value="/ctl/TimeTable/AddTimeTable"/>"><i
							class="fa fa-server" style="color: orange;"></i> <span
							style="color: white;"><s:message
									code="label.addtimetable" /></span></a></li>


					<li class="nav-item dropdown text-nowrap"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href=""
						role="button" aria-haspopup="true" aria-expanded="false" style="color:white;"> <span><i
								class="fa fa-address-book"
								style="color: orange; font-size: 14px;"></i></span>&nbsp;<span
							style="color: white; font-size: 14px;"><s:message
									code="label.marksheet" /></span></a>

						<div class="dropdown-menu dropdown-menu-right" style="background-color: #cceeff;">

							<a class="dropdown-item"
								href="<c:url value="/ctl/Marksheet/AddMarksheet"/>"><i
								class="fa fa-arrow-circle-right" aria-hidden="true"></i>&nbsp;&nbsp; <span
								style="color: #8A2BE2;"><s:message
										code="label.addmarksheet" /></span></a> <a class="dropdown-item"
								href="<c:url value="/ctl/Marksheet/GetMarksheet"/>"><i
								class="fa fa-arrow-circle-right" aria-hidden="true"></i> <span
								style="color: #8A2BE2;"><s:message
										code="label.getmarksheet" /></span></a> <a class="dropdown-item"
								href="<c:url value="/ctl/Marksheet/MeritList"/>"><i
								class='fa fa-user-circle' style="color: #0f6810;"></i><span
								style="color: #3fcc41;"> <span style="color: #8A2BE2;"><s:message
											code="label.marksheetmeritlist" /></span></span></a>



						</div></li>


				</c:if>

				<li class="nav-item dropdown"></li>
			</ul>
			
			
			
		<div class="navbar nav-item navbar-nav dropdown text-nowrap dropdown-menu-left collapse">

			<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" style="font-size: 15px;color: white;"
				role="button" aria-haspopup="true" aria-expanded="false"> <span><i
					class="fa fa-user-circle" style="color: orange;"></i></span><span
				style="color: white;"> <c:if
						test="${not empty sessionScope.user}">
						<c:set var="name" value="${sessionScope.user.firstName}" />
						<c:set var="role" value='${sessionScope.user.roleName}' />
						<c:out value="${name}(${role})"></c:out>
					</c:if> <c:if test="${empty sessionScope.user}">
						<s:message code="label.hiGuest"></s:message>
					</c:if>
			</span></a>

			<div class="dropdown-menu dropdown-menu-right" style="font-size: 15px;background-color: e6f7ff">

				<c:if test="${not empty sessionScope.user}">

					<a class="dropdown-item"
						href="<c:url value="/ctl/User/MyProfileCtl" />"><i
						class='fa fa-user-circle' style="color: #0f6810;"></i><span
						style="color: #3fcc41;"> <span style="color: #8A2BE2;"><s:message
									code="label.myprofile" /></span></span></a>

					<a class="dropdown-item"
						href="<c:url value="/ctl/User/ChangePasswordCtl"/>"><i
						class="fa fa-random" aria-hidden="true" style="color: #0f6810;"></i>

						<span style="color: #3fcc41;"><span style="color: #8A2BE2;"><s:message
									code="label.changepassword" /></span> </span></a>

					<a class="dropdown-item" target="blank"
						href="<c:url value="/resources/doc/index.html"/>"><i
						class='fas fa-caret-square-right' style="color: #0f6810;"></i> <span
						style="color: #3fcc41;"><span style="color: #8A2BE2;"><s:message
									code="label.javadoc" /></span></span></a>
                           
                            <%-- <c:url var="logoutUrl" value="/Login">
                          <c:param name="signout" value="logout"></c:param>
                           </c:url> 
<c:url  value="${logoutUrl}"/> --%>
					<a class="dropdown-item" href="<c:url value="/Login">
                          <c:param name="signout" value="logout"></c:param>
                           </c:url>"><i
						class='fas fa-caret-square-left' style="color: #0f6810;"></i> <span
						style="color: #3fcc41;"><span style="color:#8A2BE2;"><s:message
									code="label.logout" /></span></span></a>

				</c:if>

				<c:if test="${empty sessionScope.user}">

					<a class="dropdown-item" href="<c:url value="/Login"></c:url>"><i
						class="fa fa-arrow-circle-right" aria-hidden="true"></i> <span
						style="color: #8A2BE2;"><s:message code="label.login" /></span></a>

					<a class="dropdown-item"
						href="<c:url value="/Registration"></c:url>"><i
						class="fa fa-arrow-circle-right" aria-hidden="true"></i> <span
						style="color: #8A2BE2;"><s:message code="label.signup" /></span></a>

				</c:if>


			</div>

		</div>
			
		</div>


	</nav>
	<br><br><br>
&nbsp;&nbsp;<div class="btn-group" role="group" style="font-size: 10px;">
				<a class="btn btn-outline-primary" style="font-size: 10px;color: black;"
					href='<c:url value="?lang=en"></c:url>'><strong>English</strong></a>
				<a class="btn btn-outline-primary" style="font-size: 10px;color: black;"
					href='<c:url value="?lang=hi"></c:url>'><strong>हिन्दी</strong></a>
			</div>
			
</body>

</html>
