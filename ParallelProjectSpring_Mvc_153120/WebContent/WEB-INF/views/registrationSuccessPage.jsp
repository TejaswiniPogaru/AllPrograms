<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegistrationSuucessPage</title>
</head>
<body>
<center>
<h2>Welcome ${customer.name}</h2><br>
<h3>Your registered mobile number is :- ${customer.mobileNo}</h3>
<h3>Your current balance is :- ${customer.wallet.balance}</h3>

</center>
</body>
</html>