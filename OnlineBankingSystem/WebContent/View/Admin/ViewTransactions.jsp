<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<c:if test="${sessionScope.name == null}">
			<c:redirect url="/View/LoginPage.jsp"></c:redirect>
		</c:if>
		
		<p align=right ><a href="logout.do">Logout</a></p>
		<h1 align="center">Admin's view transactions</h1>
		
		<c:if test="${requestScope.transactions == null }">
			<p align="center" style="color:red;font-size:20px">No transactions made</p>
		</c:if>
		
		<c:if test="${requestScope.transactions != null }">
			<table align="center" cellspacing='5' border='1'>
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
	</body>
</html>