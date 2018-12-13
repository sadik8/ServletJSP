<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${sessionScope.customer == null}">
				<jsp:forward page="LoginPage.jsp"/>
		</c:if>
		<p align=right ><a href="logout.do">Logout</a></p>

		<h1 align="center">Account Overview</h1>
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
		<c:if test="${requestScope.account == null }">
			<c:redirect url="getAccountOverview.do"></c:redirect>
		</c:if>
		
		<c:if test="${requestScope.account != null}">
			<table align="center" border='1' cellspacing='5'>
				<caption style="font-size:30px">Account Details</caption>
				<tr>
					<th>Account Number</th>
					<td>${requestScope.account.accountNumber }</td>
				</tr>
				<tr>
					<th>Customer Name</th>
					<td>${sessionScope.customer.customerName }</td>
				</tr>
				<tr>
					<th>Customer Email</th>
					<td>${email}</td>
				</tr>
				<tr>
					<th>Customer Address</th>
					<td>${address}</td>
				</tr>
				<tr>
					<th>Account Type</th>
					<td>${requestScope.account.accountType }</td>
				</tr>
				<tr>
					<th>Account Balance</th>
					<td>${requestScope.account.accountBalance }</td>
				</tr>
				<tr>
					<th>IFSC Code</th>
					<td>${requestScope.account.ifscCode }</td>
				</tr>
				<tr>
					<th>Account Open Date</th>
					<td>${requestScope.account.openDate }</td>
				</tr>
			</table>
		</c:if>
	</body>
</html>