<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<style type="text/css">
<%@ include file="../../resource/css/divStyle.css" %>
<%@ include file="../../resource/css/button.css" %>
</style>
</head>
<body background="../../images/loginBackground.jpg">
	<div align="center" id="wrapper">		
		<div class="divBody" style="margin-top: 100px;  width: 615px;  height: 400px; background: rgba(255, 255, 255, 0.7);">
		
			<div align="left"  style="margin-left:2cm; margin-top: 50px">
				<h1 style="font-family: "Brush Script MT", cursive;">The Uniportal</h1> 			
			</div>	
			<div align="right" style="margin-top: 5px;  width: 615px;  height: 62px; background: #0B0B3B;">
			<label style="color:white;  margin-right:1cm; font-style:italic; font-family:'Times New Roman'">Sign in</label>
			</div>				
			
			<div style="margin-top: 10px">
			<b> ${loginMOTD} </b> <br/> <br/> <br/>
			<form method="post" action='loginSubmitted' class="login">
				<input id="requestingUrl" name="requestingUrl" type="hidden"
					value="${requestingUrl}">
				<table>
					<tr>						
						<td><label style="color:#0B0B3B"><b>User Name:</b></label></td>
						<td><input type="text" name="loginId" id="loginId" placeholder="User Name"></td>
					</tr>

					<tr>
						<td><label style="color:#0B0B3B"><b>Password</b></label></td>
						<td><input type="password" name="password" id="password" placeholder="Password"></td>
					</tr>
					<tr>
						<td/>
						<td><input name="Login" type="submit" value="Login" class="loginButton"></td>
					</tr>

<tr>
						<td>
						<td><a href="#">Forgot your password?</a></td>
					</tr>
				</table>
			</form>
			</div>
			<hr/>
			Experiance More with Uniportal | browse more functionalities  <br/> <br/>
		</div>
		<div align="center"> Uniportal 2014 &copy;  all right reserved</div>
	</div>
	
</body>
</html>