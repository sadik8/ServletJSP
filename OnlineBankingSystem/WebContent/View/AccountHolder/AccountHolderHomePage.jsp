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
	<h1 align="center">Welcome ${sessionScope.customer.customerName}</h1>
	<table align="center" border="1" cellspacing='20' cellpadding='5'>
		<tr>
			<td><a href="AccountHolder\AccountOverview.jsp">Account Overview</a></td>
			<td><a href="AccountHolder\TransferFunds.jsp">Fund Transfer</a></td>
			<td><a href="AccountHolder\MiniStatement.jsp">Mini Statement</a></td>
			<td><a href="AccountHolder\RequestForChangingCredentials.jsp">Change Credentials</a></td>
			<td><a href="AccountHolder\PutServiceRequest.jsp">Put Service Request</a></td>
			<td><a href="AccountHolder\TrackServiceRequest.jsp">Track Service Request</a></td>
			<td><a href="AccountHolder\ChangePassword.jsp">Change Password</a></td>
			</tr>
	</table>
</body>
</html>