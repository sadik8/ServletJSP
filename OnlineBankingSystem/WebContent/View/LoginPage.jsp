<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
		<link rel="stylesheet" type="text/css" href="project.css"/>		
		
		<script>
			function loginto()
			{
// 				var uname=document.getElementById("userName").value;
// 				var psw=document.getElementById("password").value;
// 				if(uname.substring(0,3)=="ACH")
// 				{	
// 					if(uname=="ACH101157" && psw=="Ss123456")
// 						window.open("AccountHolderHomePage.jsp","_self","");
// 					else
// 						alert("Wrong User Id or Password u");
// 				}
// 				else if(uname.substring(0,3)=="ADM")
// 				{
// 					if(uname=="ADM101157" && psw=="Ss123456")
// 						window.open("AdminHomePage.jsp","_self","");
// 					else
// 						alert("Wrong user id or password");
// 				}
// 				else
// 					alert("Wrong User Id or Password");
					
// 				return false;	

				var uname = document.getElementById("user").value;
				if(uname.substring(0,3)=="ACH" || uname.substring(0,3)=="ADM")
					return true;
				else
				{
					alert("Not a valid username");
					return false;
				}
			}
		</script>
	</head>
	<body>
		<div id="login">
			<h1 align="center"><strong>Welcome to the Online Banking Portal<br/></strong> Please login here</h1>
			
			<form action="login.do" method="post" onsubmit="return loginto()">
				<fieldset>
					<p>
						<input type="text" required name="userName" id="user" pattern="[A-Z]{3}[0-9]{6}" placeholder="Username" title="Not a valid user id!">
					</p>
					<p>
						<input type="password" required name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"	placeholder="Password" title="Invalid password!">
					</p>
					<p><a href="ForgotPassword.jsp">Forgot Password?</a></p>
					<p><input type="submit" name="submit" value="Login"></p>
				</fieldset>
			</form>
			
			<c:if test="${message != null }">
				<p style="color:red"><c:out value="${message }"/></p>
			</c:if>
			
			<c:if test="${changeMsg != null }">
				<p style="color:green"><c:out value="${changeMsg }"/></p>
			</c:if>
			
		</div> 
	</body>
</html>