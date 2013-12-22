<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of Students</title>
	
	<!-- Jsp file containing, Jquery separated into different file, 
		 so that it will be converted to a separate java file,
		 Otherwise stack overflow problem will happen while parsing the jsp file -->
	<jsp:include page="JqueryContainer.jsp" />
	
	<style type="text/css">
		<%@include file="../../resource/css/divStyle.css"%>
		<%@include file="../../resource/css/HeaderTable.css"%>
		<%@include file="../../resource/css/table.css"%>
		</style>
		<script type="text/javascript">
		<%@ include file="../../resource/js/deleteStudent.js" %>
	</script>

	<script type="text/javascript">
	$( document ).ready(function() {
		$('#loading').hide(); 
	});
	</script>
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
			        <div> <b>List of Students</b></div> 
	        	<div align="left" id="rightMain" style="background:#F2F2F2; height:auto; margin-left: 5px;">
	        		<br>        		
			        	<div id="loading"  align="center">
							<img src="../../images/loading.gif">
							<br>Please wait while we are handling your request  
						</div>
						<div align="center"><label id="deleteResult" style="color:green"></label></div>
						<table cellspacing='0' align="center" id="StudentListTable" class="mainTable">
						<thead><tr><td>ID</td><td>First Name</td><td>Last Name</td><td></td><td></td><td><h3><a href="./exportStudents">Export</a></h3></td></tr></thead>
						<tbody>
						
						<c:forEach items="${students}" var="student" varStatus="loop">
						<tr class="${loop.index % 2 == 0 ? 'even' : 'odd'}" id="ROWID_${loop.index}">
						<td>${student.id}</td>
						<td>${student.firstName}</td>
						<td>${student.lastName}</td>
						<td><a href="./studentDetail?id=${student.id}">Show Detail</a></td>
						
						<!-- form with post action is used to avoid passing student id in the url, which may lead to an intentional update/delete of a student -->
						<td>
						<form action="studentUpdate" method="post">
						<input id="id" name="id" type="hidden" value="${student.id}">
						<input id="update" name="update" type="submit" value="update">
						</form>
						</td>
						
						<td>
						<input id="delete" name="delete" type="submit" value="Delete!" onclick="deleteByAjax(${student.id}, ${loop.index});">
						</td>
						</tr>	
						
						</c:forEach>
						
						</tbody>
						</table>
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