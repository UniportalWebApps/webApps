<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Detail</title>
</head>
<body background="../../images/studentPage.jpg">
<jsp:include page="main.jsp" />
<hr/>
<div align="center" >
<font color="white">
ID: ${singleStudentsDetail.id}<br/>
First Name : ${singleStudentsDetail.firstName}<br/>
Last Name  : ${singleStudentsDetail.lastName} <br/>
<img src="/SDRS/imageController/${singleStudentsDetail.id}" alt="student Image" width = "150" height = "210"/>
</font>
</div>
</body>
</html>