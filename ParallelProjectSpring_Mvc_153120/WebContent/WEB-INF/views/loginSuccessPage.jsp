<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<div><h2>Welcome ${customer.name}</h2><br></div>
<h3>Your current balance is :- ${customer.wallet.balance}</h3><br>
<h3>Menu</h3>
<a href="fundTransfer">Fund Transfer</a><br>
 <a href="deposit">Deposit Amount</a><br> 

<a href="withdraw">WithDraw Amount </a><br>
</center>

</body>
</html>