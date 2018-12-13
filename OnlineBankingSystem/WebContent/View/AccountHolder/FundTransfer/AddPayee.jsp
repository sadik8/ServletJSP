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
		<h1 align="center">Add Payee</h1>
		<form action="addPayee.do" method="post" align="center">
			<table cellspacing='5' border='1' align="center">
				<tr>
					<th>Payee Account Number</th>
					<th>Payee Nick Name</th>
				</tr>
				<tr>
					<td><input type="text" name="accountNo" pattern="[0-9]{2,15}"/></td>
					<td><input type="text" name="nickName" pattern="[a-zA-Z ]{2,20}"/></td>
				</tr>
				<tr>
					<td colspan='2' align="right"><input type="submit" value="Add Payee"/></td>
				</tr>
			</table>
		</form>
		
		<c:if test="${payeeId != null }">
			<p style="color:red" align="center">${payeeId }</p>
		</c:if>
		
		<c:if test="${errorMessage != null }">
			<p style="color:red" align="center">${errorMessage }</p>
		</c:if>
	</body>
</html>