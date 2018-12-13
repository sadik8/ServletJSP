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
		<h1 align="center">Transfer Money to other payees account</h1>
		<table cellspacing='5' align="center" border='1'>
			<tr>
				<th>Payee ID</th>
				<th>Payee Account Number</th>
				<th>Payee Nick Name</th>
				<th></th>
			</tr>
			<c:forEach items="${requestScope.payees}" var="payee">
				<tr>
					<td>${payee.payeeId }</td>
					<td>${payee.payeeAccountNumber }</td>
					<td>${payee.nickName }</td>
					<td><a href="transferMoney.do?payeeId=${payee.payeeId},${payee.nickName},${payee.payeeAccountNumber}">transfer money</a></td>
				</tr>
			</c:forEach>
		</table>
			<p style="font-size:20px" align="center"><a href="FundTransfer/AddPayee.jsp">Add Payee</a></p>
	</body>
</html>