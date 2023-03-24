<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Edit supplier</title>
    <link rel="stylesheet" href="./../../css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
<div class="block">
    <h2 class="catalog-name">Edit supplier</h2>
    <form method="post" action="home">
        <input type="hidden" name="command" value="update_supplier">
        <input type="hidden" name="id" value=${requestScope.supplier.id}>
        <input type="hidden" name="itemsPerPage" value="${requestScope.itemsPerPage}">
        <input type="hidden" name="currentPage" value="${requestScope.currentPage}">
        <div>
            <label class="input">Name:
                <div>
                    <input class="form-control input" id="nameInput" placeholder="Enter name" type="text" name="name"
                           value="${requestScope.supplier.name}">
                </div>
            </label>
            <label class="input">Contact person:
                <div>
                    <input class="form-control input" id="contactPersonInput" placeholder="Enter contact person" type="text" name="contactPerson"
                           value="${requestScope.supplier.contactPerson}">
                </div>
            </label>
            <label class="input">Address:
                <div>
                    <select class="form-control input" id="addressId" name="addressId" required>
                        <c:forEach var="address" items="${requestScope.addresses}">
                            <option value="${address.id}">${address.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </label>
            <label class="input">Phone number:
                <div>
                    <select class="form-control input" id="phoneNumberId" name="phoneNumberId" required>
                        <c:forEach var="phoneNumber" items="${requestScope.phoneNumbers}">
                            <option value="${phoneNumber.id}">${phoneNumber.number}</option>
                        </c:forEach>
                    </select>
                </div>
            </label>
        </div>
        <button class="btn btn-default" type="submit" name="command" value="update_supplier">UPDATE SUPPLIER</button>
        <button class="btn btn-default" type="submit" name="command" value="update_supplier">CANCEL</button>
    </form>
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