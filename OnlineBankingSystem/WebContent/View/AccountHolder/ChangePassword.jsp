<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html> -->
<!-- 	<body> -->
<%-- 	<c:if test="${sessionScope.customer == null}"> --%>
<%-- 			<jsp:forward page="LoginPage.jsp"/> --%>
<%-- 	</c:if> --%>
<!-- 	<p align=right><input type="button" value="Logout"></p> -->
<!-- 		<h1>Account Holder's Change Password</h1> -->
<!-- 	</body> -->
<!-- </html> -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<script type="text/javascript">
		function check(form)
		{
			var pass=form.newpassword.value;
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
		<title>Change Password Page</title>
	</head>
	<body>
		<c:if test="${sessionScope.customer == null}">
				<jsp:forward page="LoginPage.jsp"/>
		</c:if>
		<p align=right ><a href="logout.do">Logout</a></p>
<!-- 		<p><a href="logout.do">Logout</a></p> -->
		<h1 align="center">Change Your Password</h1>
		<table align="center" border="1" cellspacing='20' cellpadding='5'>
			<tr>
				<td><a href="AccountOverview.jsp">Account Overview</a></td>
				<td><a href="TransferFunds.jsp">Fund Transfer</a></td>
				<td><a href="MiniStatement.jsp">Mini Statement</a></td>
				<td><a href="RequestForChangingCredentials.jsp">Change Credentials</a></td>
				<td><a href="PutServiceRequest.jsp">Put Service Request</a></td>
				<td><a href="TrackServiceRequest.jsp">Track Service Request</a></td>
				<td><a href="ChangePassword.jsp">Change Password</a></td>
				</tr>
		</table>
		<br/>
		<br/>
		<form action="changePassword.do" method="post" onsubmit="return check(this)">
			<table border="1" align="center">
				<caption style="font-size:30px">Change Password</caption>
				<tr>
					<td>Old Password:</td><td><input type="password" name="oldpassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
				</tr>
				<tr>
					<td>New	Password:</td><td><input type="password" name="newpassword" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></td>
				</tr>
				<tr>
					<td>Confirm	Password:</td><td><input type="password" name="cpassword" required></td>
				</tr>
				<tr>
					<td colspan='2' align="center"><input type="submit" name="confirm" value="Confirm"/></td>
				</tr>
			</table>
		</form>
		<br/>
		<c:if test="${changeMsg != null }">
			<p align="center" style="color:red">${changeMsg }</p>
		</c:if>
	</body>
</html>