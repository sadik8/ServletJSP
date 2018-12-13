<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<c:if test="${sessionScope.customer == null}">
				<jsp:forward page="LoginPage.jsp"/>
		</c:if>
	
		<p align=right ><a href="logout.do">Logout</a></p>
		<h1 align="center">Account Holder's Transfer funds Page</h1>
		
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
		<c:if test="${newBalance != null }">
			<p align="center" style="color:green;font-size=20px">${newBalance}<br/>
					You may make another transaction</p>
		</c:if>
		<h4 align="center" style="font-size:30px">Choose trasfer mode</h4>
		<div  align="center">
			<a href="getSelfAccounts.do">Self Accounts</a><br/>
			<a href="getPayees.do">To someone else's account</a><br/>
			<a href="FundTransfer/AddPayee.jsp">Add Payee</a>
		</div>
	</body>
</html>