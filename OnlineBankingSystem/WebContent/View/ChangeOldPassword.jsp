<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript">
		function check(form)
		{
			var pass=form.password.value;
			var repass=form.cpassword.value;
			
			if(pass==repass)
			{
				return true;
			}
			else
			{
				alert("Passwords do not match !")
				return false;
			}
		}
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Change Password</title>
	</head>
	<body>
		<c:if test="${sessionScope.userId == null}">
			<jsp:forward page="LoginPage.jsp"/>
		</c:if>
		
		<form action="passwordchanged.do" method="post" onsubmit="return check(this)">
			<center><h1>Generated Code sbq500#</h1></center>
			<center><h2>Change your Password Now</h2></center>
			<table border="1" align="center">
				<tr>
					<td>Account Number:</td><td><input type="text" name="accNo" pattern="[A-Z]{3}[0-9]{6}" value="${sessionScope.accountNumber}" readonly></td>
				</tr>
				<tr>
					<td>User Id:</td><td><input type="text" name="uId" pattern="[A-Z]{3}[0-9]{6}" value="${sessionScope.userId}" readonly></td>
				</tr>
				<tr>
					<td>Enter The Generated Code:</td><td><input type="text" name="code" required></td>
				</tr>
				<tr>
					<td>New	Password:</td><td><input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
				</tr>
				<tr>
					<td>Confirm	Password:</td><td><input type="password" name="cpassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit" value="Change Password"/></td>
				</tr>
			</table>
		</form>
		
		<c:if test="${msg != null }">
			<p style="color:green" align="center">${msg}</p>
		</c:if>
	</body>
</html>