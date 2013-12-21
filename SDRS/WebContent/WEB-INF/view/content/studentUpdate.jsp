<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
</head>

<body background="../../images/studentPage.jpg">

	<form action="student_updated" method="post">
		<font color="white">
			<table border=0 align="center">
				<!-- hidden field is used to submit student id with form -->
				<tr>
					<td>ID:</td>
					<td>${singleStudentsDetail.id}<input id="id" name="id"
						type="hidden" value="${singleStudentsDetail.id}"></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input id="firstName" name="firstName" type="text"
						value="${singleStudentsDetail.firstName}"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input id="lastName" name="lastName" type="text"
						value="${singleStudentsDetail.lastName}"></td>
				</tr>
				<tr>
					<td></td>
					<td><input name="update" type="submit"></td>
				</tr>
			</table>
		</font>
	</form>

</body>
</html>