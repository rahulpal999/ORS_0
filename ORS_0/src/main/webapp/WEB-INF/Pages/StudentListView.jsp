<%@page import="in.co.sunrays.proj0.dto.RoleDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div class="row d-flex justify-content-center h-100">
	
	<div class="col-lg-12 col-sm-12 ml-auto mr-auto">
		<div class="card card-table"
			style="background-color: #ffffff0d;">
			<h3 class="w-100 text-center under-over-line">
				<s:message code="label.studentlist"></s:message>
			</h3>

			<!-- Error -->
			<c:if test="${error != null}">
				<div class="alert alert-danger alert-with-icon text-center"
					data-notify="container">
					<div class="container">
						<div class="alert-wrapper">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="message">
								<i class="nc-icon nc-bell-55"></i>${error}
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<!-- //Error -->
			<!-- Success -->
			<c:if test="${success != null}">
				<div class="alert alert-success alert-with-icon text-center"
					data-notify="container">
					<div class="container">
						<div class="alert-wrapper">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<div class="message">
								<i class="nc-icon nc-bell-55"></i>${success}
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<!-- //Success -->
			<sf:form class="register-form" method="post" modelAttribute="form">
				<c:set value="${((form.pageNo-1)*form.pageSize)+1}" var="index"></c:set>
				<sf:hidden path="pageNo" />
				<sf:hidden path="pageSize" />
				<c:if test="${!empty list}">
					<div class="row p-2 d-flex justify-content-center">

						<div class="col-lg-3">
							<sf:input path="firstName"
								cssClass="form-control border-left-right"
								placeholder="${enterfirstName}" />
						</div>
						<div class="col-lg-3">
							<sf:select path="collegeId"
								class="form-control border-left-right">
								<sf:option value="0">
									<s:message code="label.selectcollege" />
								</sf:option>
								<sf:options items="${collegeList}" itemValue="id"
									itemLabel="name" />
							</sf:select>
						</div>
						<div class="col-lg-3">
							<div class="row">
								<div class="col-6">
									<button type="submit"
										class="btn btn-outline-info btn-block btn-round w-100" name="operation"
										name="operation" value="Search">
										<s:message code="label.search" />
									</button>
								</div>
								<div class="col-6">
									<button type="submit"
										class="btn btn-outline-danger btn-block btn-round w-100" name="operation"
										name="operation" value="Reset">
										<s:message code="label.reset" />
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row d-flex justify-content-center">
						<div class="col-lg-12 table-responsive">
							<table
								class="table table-hover table-striped border border-secondary">
								<thead style="background-color: #4B0082;">
									<tr>
										<th scope="col" class="text-center text-white"><input
											type="checkbox" id="select_all" /></th>
										<th scope="col" class="text-center" style="color: white;">S.No.</th>
										<th scope="col" class="text-center" style="color: white;"><s:message
												code="label.firstName" /></th>
										<th scope="col" class="text-center" style="color: white;"><s:message
												code="label.lastName" /></th>
										<%--  <th scope="col" class="text-center" style="color: white;"><s:message code="label.emailId"/></th> --%>
										<th scope="col" class="text-center" style="color: white;"><s:message
												code="label.mobileNo" /></th>
										<th scope="col" class="text-center" style="color: white;"><s:message
												code="label.dob" /></th>
										<th scope="col" class="text-center" style="color: white;"><s:message
												code="label.collegeName" /></th>
										<th scope="col" class="text-center" style="color: white;"><s:message
												code="label.edit" /></th>
									</tr>
								</thead>
								<tbody style="background-color: white;">
									<c:forEach items="${list}" var="student" varStatus="ct">
										<tr>
											<td class="text-center"><input class="checkbox"
												name="chk_1" type="checkbox" value="${student.id}">
											</td>
											<td class="text-center"><c:out
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
												<c:set var="index"
													value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
											</td>
											<td class="text-center">${student.firstName}</td>
											<td class="text-center">${student.lastName}</td>
											<%-- <td class="text-center">${student.EmailId}</td> --%>
											<td class="text-center">${student.mobileNo}</td>
											<td class="text-center"><fmt:formatDate pattern="dd/MM/yyyy" value="${student.dob}" /></td>

											<c:forEach items="${collegeList}" var="clg">
												<c:if test="${student.collegeId==clg.id}">
													<td class="text-center">${clg.name}</td>

												</c:if>
											</c:forEach>

											<td class="text-center"><c:url var="editUrl"
													value="/ctl/Student/AddStudent?id=" /> <a
												class="btn btn-outline-success btn-block btn-round w-100"
												style="border-color: #8A2BE2; color: #8A2BE2;" name="operation"
												href="${editUrl}${student.id}"><i class="fa fa-edit"
													aria-hidden="true"></i>
												<s:message code="label.edit" /></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row d-flex justify-content-center">
						<div class="col-lg-1 col-3">
							<c:choose>
								<c:when test="${form.pageNo > 1}">
									<button type="submit"
										class="btn btn-outline-primary btn-block btn-round w-100"
										 name="operation"
										name="operation" value="Previous">
										<i class="fa fa-arrow-circle-left" aria-hidden="true"></i>
									</button>
								</c:when>
								<c:otherwise>
									<button type="submit"
										class="btn btn-outline-secondary btn-block btn-round w-100"
										name="operation" value="Previous" disabled>
										<i class="fa fa-arrow-circle-left" aria-hidden="true"></i>
									</button>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="col-lg-1 col-3">
							<button type="submit"
								class="btn btn-outline-success btn-block btn-round w-100"
								 name="operation"
								name="operation" value="New">
								<i class="fa fa-plus" aria-hidden="true"></i>
							</button>
						</div>
						<div class="col-lg-1 col-3">
							<button type="submit"
								class="btn btn-outline-danger btn-block btn-round w-100"
								 name="operation"
								name="operation" value="Delete">
								<i class="fa fa-trash" aria-hidden="true"></i>
							</button>
						</div>
						<div class="col-lg-1 col-3">
							<c:choose>
								<c:when test="${nextlistsize != 0}">
									<button type="submit"
										class="btn btn-outline-primary btn-block btn-round w-100"
										 name="operation"
										name="operation" value="Next">
										<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
									</button>
								</c:when>
								<c:otherwise>
									<button type="submit"
										class="btn btn-outline-secondary btn-block btn-round w-100"
										 name="operation"
										name="operation" value="Next" disabled>
										<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
									</button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:if>
				<c:if test="${empty list}">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-2 col-6">
							<button type="submit"
								class="btn btn-outline-warning btn-block btn-round w-100"
								 name="operation"
								name="operation" value="Back">
								<i class="fa fa-reply" aria-hidden="true"></i>
								<s:message code="label.back"></s:message>
							</button>
						</div>
					</div>
				</c:if>
			</sf:form>
		</div>
	</div>
</div>
</body>
<br><br><br><br>
</html>