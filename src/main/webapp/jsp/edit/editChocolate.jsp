<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit chocolate</title>
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
    <h2 class="catalog-name">Edit chocolate</h2>
    <form method="post" action="home">
        <input type="hidden" name="command" value="update_chocolate">
        <input type="hidden" name="id" value=${requestScope.chocolate.id}>
        <div>
            <label class="input">Price:
                <div>
                    <input id="priceInput" class="form-control input" placeholder="Enter price" type="text" name="price"
                           value="${requestScope.chocolate.price}">
                </div>
            </label> <br>
            <label class="input">Type:
                <div>
                    <input id="typeInput" type="text" class="form-control input" placeholder='Enter type' name="type"
                           value="${requestScope.chocolate.type}">
                </div>
            </label> <br>
            <label class="input">Weight:
                <div>
                    <input id="weightInput" type="text" class="form-control input" placeholder='Enter weight' name="weight"
                           value="${requestScope.chocolate.weight}">
                </div>
            </label> <br>
            <label class="input">Composition:
                <div>
                    <input id="compositionInput" type="text" class="form-control input" placeholder='Enter composition'
                           name="composition"
                           value="${requestScope.chocolate.composition}">
                </div>
            </label> <br>
            <label class="input">Brand:
                <div>
                    <select class="form-control input" id="brandId" name="brandId" required>
                        <c:forEach var="brand" items="${requestScope.brands}">
                            <option value="${brand.id}">${brand.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </label> <br>
            <label class="input">Store:
                <div>
                    <select class="form-control input" id="storeId" name="storeId" required>
                        <c:forEach var="store" items="${requestScope.stores}">
                            <option value="${store.addressId}">${store.addressName}</option>
                        </c:forEach>
                    </select>
                </div>
            </label> <br>
            <label class="input">Supplier:
                <div>
                    <select class="form-control input" id="supplierId" name="supplierId" required>
                        <c:forEach var="supplier" items="${requestScope.suppliers}">
                            <option value="${supplier.id}">${supplier.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </label>
        </div>
        <button type="submit" name="command" value="update_chocolate" class="btn btn-default">UPDATE CHOCOLATE</button>
        <a href="home?command=read_chocolate" class="btn btn-default">CANCEL</a>
    </form>
</div>
<footer class="footerNP">
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