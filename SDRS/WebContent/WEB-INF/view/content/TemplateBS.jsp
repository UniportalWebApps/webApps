<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<!-- Jsp file containing, Jquery separated into different file, 
	 so that it will be converted to a separate java file,
	 Otherwise stack overflow problem will happen while parsing the jsp file -->
<jsp:include page="JqueryContainer.jsp" />


<script type="text/javascript">
$( document ).ready(function() {
	
	$("#EXPND_LEFT").hide();
	
	$( "#CLPS_LEFT" ).click(function(){
		$("#CLPS_LEFT").hide();
		$("#leftMain").hide();
		$("#EXPND_LEFT").show();		
	});
	
	
	$( "#EXPND_LEFT" ).click(function(){
		$("#EXPND_LEFT").hide();
		$("#CLPS_LEFT").show();
		$("#leftMain").show();			
	});

});
</script>

<style type="text/css">
<%@ include file="../../resource/css/bootstrap.min.css" %>
<%@ include file="../../resource/css/HeaderTable.css" %>
</style>
</head>
<body background="../../images/school.jpg" style="text-align: center">
<div align="center" class="divBody" style="margin:0 auto;">
<label style="letter-spacing:4px; position: center"><h3>The Uniportal</h3></label>
<jsp:include page="Header.jsp" />
	<marquee behavior="scroll" direction="left" scrollamount="1.5">your news goes here ...  </marquee>
	<div class="container">
		Testing bootstrap div 
	</div>
    <div align="center" style="display: table-row;" class="row-fluid">
    
    	<!-- Left side Div -->
        <div align="center" style="width: 600px; display: table-cell; height:440px; width:210px;">
        	<div align="center" style="background:#0B0B3B; height:35px;  margin-left: 10px;  moz-border-radius-topleft: 13px; -webkit-border-top-left-radius: 13px;
   							border-top-left-radius: 13px; -moz-border-radius-topright: 13px; -webkit-border-top-right-radius: 13px; border-top-right-radius: 13px;">
   					<label style="position:center; color: white"> <b>Quick Search </b></label>
   					<div align="right"> 
        			<img src="../../images/collapse.png" id="CLPS_LEFT" alt="-">
        			<img src="../../images/expand.png" id="EXPND_LEFT" alt="+">
        			</div>
        	</div> 
        	<div align="left" id="leftMain" style="background:#F2F2F2; height:250px; margin-left: 5px;"> 
        		<br>  		
		        Quick Search <br>
		        <input type="text"><br>
	        </div>
        </div>
        
        <!-- Main body Div -->
        <div align="center" style="display: table-cell; height:auto; width:780px;"> 
        	<div align="center" style="background:#0B0B3B; height:35px;  margin-left: 5px; moz-border-radius-topleft: 13px; -webkit-border-top-left-radius: 13px;
   							border-top-left-radius: 13px; -moz-border-radius-topright: 13px; -webkit-border-top-right-radius: 13px; border-top-right-radius: 13px;">
   					<label style="position:center; color: white"> <b>Main title</b> </label>
        	</div> 
        	<div align="left" id="rightMain" style="background:#F2F2F2; height:auto; margin-left: 5px;">
        		<br>        		
		        Main Body goes here .... 
	        </div>
         
        </div>
    </div>
</div>
</body>
</html>