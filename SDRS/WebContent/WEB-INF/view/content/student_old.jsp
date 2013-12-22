<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
               
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Jsp file containing, Jquery separated into different file, 
	 so that it will be converted to a separate java file,
	 Otherwise stack overflow problem will happen while parsing the jsp file -->
<jsp:include page="JqueryContainer.jsp" />

<!-- Jsp file containing, Jquery Validator -->
<jsp:include page="JqueryValidator.jsp" />

<script type="text/javascript">
<%@include file="../../resource/js/studentFormValidator.js"%>
</script>


<style type="text/css">
<%@ include file="../../resource/css/button.css" %>
<%@ include file="../../resource/css/textBox.css" %>
<%@ include file="../../resource/css/divStyle.css" %>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body background="../../images/school.jpg">
<jsp:include page="main.jsp" />
<hr/>
<div align="center" id="wrapper">
<div class="divBody">



</div>
</div>
<script> $.validate(); </script>
</body>
</html>