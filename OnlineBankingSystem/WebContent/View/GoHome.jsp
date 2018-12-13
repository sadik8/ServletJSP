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
	<c:if test="${changeMsg != null}">
		<p style="color:green">${changeMsg}</p>
		<script>
			alert("Password Changed Successfully");
		</script>
	</c:if>
	<c:redirect url="/View/AccountHolder/AccountHolderHomePage.jsp"></c:redirect>
</body>
</html>