<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.academy.controller.CommandInvoker " %>
<html>
<head>
    <title>Confectionery store</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<div class="header">
    <a class="active" href="index.jsp">Home</a>
    <a href="home?command=read_chocolate">Chocolate</a>
    <a href="home?command=read_cookie">Cookies</a>
    <a href="home?command=read_sweets">Sweets</a>
    <a href="home?command=read_brand">Brands</a>
    <a href="home?command=read_store">Stores</a>
    <a href="home?command=read_supplier">Suppliers</a>
    <a href="home?command=read_address">Addresses</a>
    <a href="home?command=read_phone_number">Contacts</a>
</div>
<div class="catalog-name">
    <h1>Product catalog</h1>
</div>

<div class="catalog">
    <a class="item" href="home?command=read_chocolate">
        <img src="./images/shocolate.png" alt="">
        <span>Chocolate</span>
    </a>
    <a class="item" href="home?command=read_cookie">
        <img src="./images/cookie.png" alt="">
        <span>Cookies</span>
    </a>
    <a class="item" href="home?command=read_sweets">
        <img src="./images/candies.png" alt="">
        <span>Sweets</span>
    </a>
</div>
<footer class="footer">
    <div class="wrap wrap__footer">
        <div class="footer__top">
            <div class="footer__nav">
                <ul>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="home?command=read_brand">Brands</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/sale">Sale</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/all-cats">Product catalog</a>
                    </li>
                </ul>
                <ul>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/news">News</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="/shipping">Shipping and payment</a>
                    </li>
                    <li class="footer__nav-item">
                        <a class="footer__nav-link" href="home?command=read_phone_number">Contacts</a>
                    </li>
                </ul>
            </div>
            <div class="footer__top-right">

                <div class="footer__time">
                    <div class="footer__day-work">
                        <p>Opening hours: <span>09.00 - 21.00</span></p>
                        <div class="footer__day-items">
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                            <div class="footer__day-item"></div>
                        </div>
                    </div>
                </div>
            </div>
            <ul class="footer__cards">
                <li class="footer__card footer__card-visa"></li>
                <li class="footer__card footer__card-master"></li>
            </ul>
        </div>


    </div>
</footer>
</body>
</html>