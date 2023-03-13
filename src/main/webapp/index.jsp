<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.academy.controller.CommandInvoker " %>
<html>
<head>
    <title>Confectionery store</title>
</head>
<body>
<div>
    <h1>Confectionery store</h1>
</div>

<div>
    <a class="active" href="index.jsp">Главная</a>
    <a href="home?command=read_chocolate">Chocolate</a>
    <a href="home?command=read_cookie">Cookies</a>
    <a href="home?command=read_sweets">Sweets</a>
    <a href="home?command=read_brand">Brands</a>
    <a href="home?command=read_store">Stores</a>
    <a href="home?command=read_supplier">Suppliers</a>
    <a href="home?command=read_address">Addresses</a>
    <a href="home?command=read_phone_number">Contacts</a>
</div>

</body>
</html>