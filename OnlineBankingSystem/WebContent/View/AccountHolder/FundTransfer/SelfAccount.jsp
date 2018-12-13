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
				<jsp:forward page="/index.jsp"/>
		</c:if>

		<p align=right ><a href="logout.do">Logout</a></p>
		<h1 align="center">Transfer Money to self Accounts</h1>
		<c:if test="${requestScope.selfAccounts != null}">
			<table cellspacing='5' align="center" border='1'>
				<tr>
					<th>Account Number</th>
					<th>Account Type</th>
					<th>IFSC Code</th>
					<th></th>
				</tr>
				<c:forEach items="${requestScope.selfAccounts}" var="account">
					<tr>
						<td>${account.accountNumber}</td>
						<td>${account.accountType}</td>
						<td>${account.ifscCode}</td>
						<td><a href="transferMoneySelf.do?payeeAccountNumber=${account.accountNumber}">transfer money</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${requestScope.selfAccounts == null}">
			<p style="color:red" align="center">You don't have any other accounts</p>
		</c:if>
	</body>
</html>