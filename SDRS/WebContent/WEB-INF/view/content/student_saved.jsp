<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Saved</title>
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
		        <div align="center">				
					<c:if test="${not empty FormValidationMsg}">
					<label style="color:red"><b> ${FormValidationMsg} <br/> !!</b></label>
					</c:if>
					
					<c:if test="${not empty saveMessage}">
					<b> ${saveMessage} <br/> you may proceed registering another student</b>
					</c:if>
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