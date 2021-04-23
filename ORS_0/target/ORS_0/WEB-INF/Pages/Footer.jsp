<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.footer {
	position: fixed;
	right: 0;
	bottom: 0;
	color: gainsboro;
	left: 0;
	display: block;
	/*  padding: 0.5rem; */
	box-shadow: 0px 0px 0px 0px #244a4a;
	text-align: center;
	z-index: 2500;
}
</style>

</head>
<body >
<div class="container-fluid">

<div class="footer" style="background-color:rgb(0, 102, 255);">
  <p style="color:white;" class="text-center">&copy; Copyright <%=Calendar.getInstance().getWeekYear()%> :Rays Technologies</p>
</div>
</div>
</body>
</html>