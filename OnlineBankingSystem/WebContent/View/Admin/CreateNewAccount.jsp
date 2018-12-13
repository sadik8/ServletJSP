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
		<h2 align="center">Admin's create new account page</h2>
		
		<c:if test="${requestScope.accountNo_userId != null}">
			<p style="color:green" align="center"><c:out value="Account generated with following"/></p>
			<p style="color:green" align="center"><c:out value="Account Number : ${accountNo_userId[0] }"/></p>
			<p style="color:green" align="center"><c:out value="User Id : ACH${accountNo_userId[1] }"/></p>
		</c:if>
		
	<form action="createNewAccount.do" method="post" align="center">
		<table callspacing='5' align="center" border='1'>
			<caption style="font-size:30px">Enter Customer Details</caption>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="customerName" pattern="[a-zA-Z ]{1,50}" required/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" required/></td>
			</tr>
			<tr>
				<td>PAN No</td>
				<td><input type="text" name="panNo" required/></td>
			</tr>
			<tr>
				<td>Login Password</td>
				<td><input type="text" name="loginPassword" required/></td>
			</tr>
			<tr>
				<td>Secret Question</td>
				<td><input type="text" name="secretQuestion" required/></td>
			</tr>
			<tr>
				<td>Transaction Password</td>
				<td><input type="text" name="transactionPassword" required/></td>
			</tr>
			<tr>
				<td>Account Type</td>
				<td>
					<select name="accountType">
						<option value="SAVINGS">Savings</option>
						<option value="CURRENT">Current</option>
						<option value="SALARY">Salary</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Account Balance</td>
				<td><input type="text" name="accountBalance" pattern="[1-9][0-9]{2,}" required/></td>
			</tr>
			<tr>
				<td>IFSC Code</td>
				<td><input type="text" name="ifscCode" required/></td>
			</tr>
			<tr>
				<td>Open Date</td>
				<td><input type="date" name="openDate" required/></td>
			</tr>
			<tr>
				<td>Lock Status</td>
				<td>
					<input type="radio" name="lockStatus" value="L">Locked
					<input type="radio" name="lockStatus" value="U" checked>Unlocked
				</td>
			</tr>
			<tr>
				<td colsapn='2' align="center"><input type="submit" value="Register Account"/></td>
			</tr>
		</table>
	</form>
	</body>
</html>