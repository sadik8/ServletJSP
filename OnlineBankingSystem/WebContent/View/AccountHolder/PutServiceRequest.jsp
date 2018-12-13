<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<c:if test="${sessionScope.customer == null}">
				<c:redirect url="/View/LoginPage.jsp"></c:redirect>
		</c:if>
		<p align=right ><a href="logout.do">Logout</a></p>
		<h1 align="center">Account Holder's Put Service Request</h1>
		
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
		<form align="center" action="putServiceRequest.do" method="post">
			<table cellspacing='5' align="center" border='1'>
				<caption style="font-size:30px">Put Your Request</caption>
				<tr>
					<td>Service Description</td>
					<td><input type="text" name="serviceDescription"/></td>
				</tr>	
				<tr>
					<td>Service Status</td>
					<td><input type="text" value="Open" readonly/></td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit" value="Put Service Request"/></td>
				</tr>
			</table>
		</form>
		<br/>
		<c:if test="${requestScope.serviceId != null}">
			<p style="color:green">Service Request added with Id : ${requestScope.serviceId}</p>
		</c:if>
	</body>
</html>