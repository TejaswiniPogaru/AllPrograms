<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<div>
			<h3>Deposit </h3>
		</div>
		<table>
			<form:form action="depositAmount" method="post"	modelAttribute="customer">
			<tr>
					<td>Mobile Number</td>
					<td><form:input path="mobileNo" size="30" /></td>
					<td><form:errors path="mobileNo" cssClass="error" /></td>
				</tr>
				
				<tr>
					<td>Enter amount</td>
					<td><form:input path="wallet.balance"  size="30" /></td>
					<td><form:errors path="wallet.balance" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Deposit"></td>
				</tr>
				
			</form:form>
			</table>
	</center>

</body>
</html>