<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<script type="text/javascript">
		function loginto()
		{
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
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Forgot Password Page</title>
	</head>
	<body>
		<form action="forgotPassword.do" method="post" onsubmit="return loginto()">
			<h1 align="center">Forgot Password Page</h1>
			<table border="1" align="center">	
				<caption style="font-size:30px"></caption>
				<tr>
					<td>Account Number : </td>
					<td><input type="text" name="accNo" pattern="[0-9]{1,20}" required></td>
				</tr>
				<tr>
					<td>User Id : </td>
					<td><input type="text" name="userId" id="user" pattern="[A-Z]{3}[0-9]{6}" required></td>
				</tr>
				<tr>
					<td>Mother's Maiden Name : </td>
					<td><input type="text" name="maiden" pattern="[A-Za-z ]{2,20}" required></td>
				</tr>
				<tr>
					<td colspan='2' align="center"><input type="submit" name="confirm" value="Confirm"/></td>
				</tr>
			</table>
		</form>
		
		<c:if test="${errorMsg != null}">
			<p style="color:red" align="center">${errorMsg }</p>
		</c:if>
	</body>
</html>


