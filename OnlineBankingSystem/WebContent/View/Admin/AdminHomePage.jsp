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
		<c:if test="${sessionScope.name == null}">
			<c:redirect url="/View/LoginPage.jsp"></c:redirect>
		</c:if>
		
		<p align=right ><a href="logout.do">Logout</a></p>
		<h1 align="center">Admin's Home Page</h1>
		<h2 align="center">Welcome <b style="font-size:20px">ADMIN</b></h2>
		<div align="center">
			<a href="Admin\CreateNewAccount.jsp">Create New Account</a><br/>
			<a href="viewTransactions.do">View Transactions</a><br/>
		</div>
	</body>
</html>