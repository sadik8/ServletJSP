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
		<h1 align="center">Account Holder's Request for changing credentials</h1>
		
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
		<c:if test="${requestScope.cust == null}">
			<c:redirect url="changecred.do"></c:redirect>
		</c:if>
		
		
		<form action="changed.do" method="post">
			<c:if test="${requestScope.cust != null}">
				<table border="1" cellspacing="5" align="center">
					<caption style="font-size:30px">Enter new Credential</caption>
					<tr>
						<th>Address</th>
						<th>Email</th>
					</tr>
					<tr>
						<td>Customer Address:<input type ="text" name="address"  value="${sessionScope.customer.address}" required/></td>
						<td>Customer Email:<input type ="email" name="email" value="${sessionScope.customer.email}" required/></td>
					</tr>
					<tr>
						<td colspan='3' align="center"><input type="submit" value="Change Credential"/></td>
					</tr>
				</table>
			</c:if>
		</form>
		
		<c:if test="${changeMsg != null}">
			<p style="color:green">${changeMsg }</p>
		</c:if>
	</body>
</html>