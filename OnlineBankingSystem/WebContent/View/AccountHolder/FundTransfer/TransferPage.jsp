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
		
		<h1 align="center">Money Transfer Page</h1>
		<c:if test="${requestScope.id != null }">
			<form action="makeTransfer.do" method="post" align="center">
				<table align="center" border='1' cellspacing='5'>
					<tr>
						<th>Payee ID</th>
						<td><input type="text" name="payeeId" value="${requestScope.id }" readonly/></td>
					</tr>
					<tr>
						<th>Payee Nick Name</th>
						<td><input type="text" name="nickName" value="${requestScope.name }" readonly/></td>
					</tr>
					<tr>
						<th>Payee Account Number</th>
						<td><input type="text" name="accNo" value="${requestScope.payeeAccNo }" readonly/></td>
					</tr>
					<tr>
						<th>Enter amount</th>
						<td><input type="text" name="money" pattern="[0-9]{2,10}" title="Enter only digits"/></td>
					</tr>
					<tr>
						<th>Enter Transfer password</th>
						<td><input type="password" name="transferPassword"/></td>
					</tr>
					<tr>
						<td colspan='2'><input type="submit" value="Transfer Money"/></td>
					</tr>
				</table>
			</form>
		</c:if>
		
		<c:if test="${requestScope.payeeAccountNo != null}">
			<form action="makeSelfTransfer.do" method="post" align="center">
				<table border='1' cellspacing='5'>
					<tr>
						<th>Self Account Number</th>
						<td><input type="text" name="accNo" value="${requestScope.payeeAccountNo }" readonly/></td>
					</tr>
					<tr>
						<th>Enter amount</th>
						<td><input type="text" name="money" pattern="[0-9]{2,10}" title="Enter only digits"/></td>
					</tr>
					<tr>
						<th>Enter Transfer password</th>
						<td><input type="password" name="transferPassword"/></td>
					</tr>
					<tr>
						<td colspan='2'><input type="submit" value="Transfer Money"/></td>
					</tr>
				</table>
			</form>
		</c:if>
		
		<c:if test="${noBalance != null}">
			<p style="color:red" align="center">${noBalance }</p>
		</c:if>
	</body>
</html>