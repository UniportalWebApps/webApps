<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Saved</title>
</head>
<body background="../../images/studentPage.jpg">
<jsp:include page="main.jsp" />
<hr/>
<div align="center">
<font color="white">

<c:if test="${not empty FormValidationMsg}">
<label style="color:red"><b> ${FormValidationMsg} <br/> !!</b></label>
</c:if>

<c:if test="${not empty saveMessage}">
<b> ${saveMessage} <br/> you may proceed registering another student</b>
</c:if>

</font>
</div>
<hr/>
</body>
</html>