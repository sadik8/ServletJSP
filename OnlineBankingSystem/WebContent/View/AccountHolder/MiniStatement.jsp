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
		<h1 align="center">Account Holder's Mini Statement Page</h1>
		
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
		<c:if test="${requestScope.transactions == null && requestScope.errorMsg == null}">
			<c:redirect url="miniStatement.do"></c:redirect>
		</c:if>
		
		<c:if test="${requestScope.transactions != null}">
			<table align="center" cellspacing='5' border='1'>
				<caption style="font-size:30px">Mini Statement</caption>
				<tr>
					<th>Transaction ID</th>
					<th>Account Number</th>
					<th>Transaction Type</th>
					<th>Transaction Amount</th>
					<th>Transaction Description</th>
					<th>Date of Transaction</th>
				</tr>
				
				<c:forEach items="${requestScope.transactions }" var="transaction">
					<tr>
						<td>${transaction.transactionID }</td>
						<td>${transaction.accountNumber }</td>
						<td>${transaction.transactionType }</td>
						<td>${transaction.transactionAmount }</td>
						<td>${transaction.transactionDescription }</td>
						<td>${transaction.dateofTransaction }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${requestScope.errorMsg != null }">
			<p align="center" style="color:red;font-size:30px">No Transactions Made</p>
		</c:if>
	</body>
</html>