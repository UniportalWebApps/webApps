<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
</head>


<body background="../../images/school.jpg" style="text-align: center">
<div align="center" class="divBody" style="margin:0 auto;">
<img src="../../images/SiteBanner.jpg">
<jsp:include page="Header.jsp" />
</div>
<div align="center" class="divBody" style="margin:0 auto;">	  		
    <div align="center" style="display: table-row;">
    
    	<!-- Left side Div -->
        <div align="center" style="width: 600px; display: table-cell; height:440px; width:210px;">
        	<div align="left" id="leftMain" style="background:#F2F2F2; height:250px; margin-left: 5px;"> 
        		<br>  		
		        Quick Search <br>
		        <input type="text"><br>
	        </div>
        </div>
        
        <!-- Main body Div -->
        <div align="center" style="display: table-cell; height:auto; width:780px;">         	
        	<div align="left" id="rightMain" style="background:#F2F2F2; height:auto; margin-left: 1px;">
        		<br>        		
		        	<div>
						<a href="#" id="reg"> <img alt="Register" src="../../images/registerStudent.png" width="60" height="60" > </a>
						<a href="#" id="addr"> <img alt="Adress" src="../../images/AddressBook.png" width="60" height="60"> </a>
						<a href="#" id="summ"> <img alt="Summary" src="../../images/StudentSummary.png" width="60" height="60"> </a>
					</div>
					
					<div id="registration">
						<h3>Student Registration From </h3>
						<form id="studentForm" action="student_saved" method="post" enctype="multipart/form-data">
							<table border=0 align="center">
								<tr><td> ID: </td> <td><input id="id" name="id"type="text" class="input-text" placeholder="Student ID"></td></tr>
								<tr><td> First Name: </td> <td><input id="firstName" name="firstName" type="text" class="input-text" placeholder="First Name"></td></tr>
								<tr><td> Last Name: </td> <td><input id="lastName" name="lastName" type="text" class="input-text" placeholder="Last Name"></td></tr>
								<tr><td> Picture: </td> <td> <input type='file' name='stdImage' id='stdImage' accept="image/gif, image/jpeg, image/png" onchange="showImage(this)"></td></tr>
								<tr><td></td><td><img id="studentImg" src="#" alt="Student Image" /></td></tr>
								<tr><td> </td> <td><input name="Save" type="submit" class="submit-button"></td></tr>
							</table>
						</form>
					</div>

				<div id="address">
				<h3>Add Student Address  </h3>
				</div>
		    </div>         
        </div>
    </div>
</div>
<div align="center" id="Signature">
<label>Uniportal&copy;2014 | All right reserved</label>
</div>

</body>
</html>