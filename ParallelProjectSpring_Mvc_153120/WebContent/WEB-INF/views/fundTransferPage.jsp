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
<h3>Fund Transfer</h3>
</div>
<table>
<form:form action="fundTransferAction" method="post" >
<tr>
<td>Source Mobile Number</td>
<td><input name ="sourcemobileNo" type ="text" size = "30"/></td>
<%-- <td><form:errors path="sourcemobileNo" cssClass="error"/></td> --%>
</tr>
<tr>
<td>Target Mobile Number</td>
<td><input name ="targetmobileNo" type ="text" size = "30"/></td>
<%-- <td><form:errors path="targetmobileNo" cssClass="error"/></td> --%>
</tr>
<tr>
<td>Amount transfered</td>
<td><input name ="amount" type ="text" size = "30"/></td>
<%-- <td><form:errors path="wallet.balance" cssClass="error"/></td> --%>
</tr>
<tr>
<td><input type="submit" value="transfer"></td>
</tr>
</form:form>
</table>
</center>

</body>
</html>