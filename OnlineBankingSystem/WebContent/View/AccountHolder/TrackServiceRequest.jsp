<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
	<c:if test="${sessionScope.customer == null}">
			<c:redirect url="/View/LoginPage.jsp"></c:redirect>
	</c:if>
		<p align=right ><a href="logout.do">Logout</a></p>
		
		<h1 align="center">Account Holder's Track Service Request</h1>
		
		
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
		<form align="center" action="trackServiceRequest.do" method="post">
			<table cellspacing='5' align="center" border='1'>
				<caption style="font-size:30px">Track Your Request</caption>
				<tr>
					<td>Enter Service Request Id :</td>
					<td><input type="text" name="serviceId" pattern="[0-9]{1,20}"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Show Status"/></td>
					<td><input type="reset" value="Reset"/></td>
				</tr>
			</table>
		</form>
		
		<c:if test="${requestScope.serviceDetails != null}">
			<table align="center">
				<caption>Details of Request</caption>
				<tr>
					<th>Service ID </th>
					<th>Service Description </th>
					<th>Account Number </th>
					<th>Service RaisedDate </th>
					<th>Service Status </th>
				</tr>
				<tr>
					<td>${requestScope.serviceDetails.serviceID}</td>
					<td>${requestScope.serviceDetails.serviceDescription}</td>
					<td>${requestScope.serviceDetails.accountNumber}</td>
					<td>${requestScope.serviceDetails.serviceRaisedDate}</td>
					<td><b>${requestScope.serviceDetails.serviceStatus}</b></td>
				</tr>
			</table>
		</c:if>
		
		<c:if test="${requestScope.norequest != null}">
			<p align="center" style="color:red">${requestScope.norequest}</p>
		</c:if>
	</body>
</html>