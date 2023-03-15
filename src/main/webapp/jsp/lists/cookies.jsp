<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie</title>
    <link rel="stylesheet" href="./../../css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<c:choose>
<c:when test="${requestScope.cookies.size() > 0}">
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
    <h1>Cookies</h1>
</div>
<div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>№</th>
            <th>Price</th>
            <th>Type</th>
            <th>Weight</th>
            <th>Composition</th>
            <th>Brand</th>
            <th>Store</th>
            <th>Supplier</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.cookies}" var="element" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${element.price}</td>
                <td>${element.type}</td>
                <td>${element.weight}</td>
                <td>${element.composition}</td>
                <td style="display:none">${element.brandId}</td>
                <td>${element.brandName}</td>
                <td style="display:none">${element.storeId}</td>
                <td>${element.storeName}</td>
                <td style="display:none">${element.supplierId}</td>
                <td>${element.supplierName}</td>
                <td>
                    <form action="home" method="get">
                        <input type="hidden" name="command" value="go_to_edit_cookie">
                        <input type="hidden" name="id" value=${element.id}>
                        <button class="button btn btn-default" type="submit" value="edit">EDIT</button>
                    </form>
                </td>
                <td>
                    <form action="home" method="post">
                        <input type="hidden" name="command" value="delete_cookie">
                        <input type="hidden" name="id" value=${element.id}>
                        <button class="button btn btn-default" type="submit" value="delete">DELETE</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:when>
    <c:otherwise>
        <div>
            <h2 class="catalog-name">There are no cookies yet!</h2>
        </div>
    </c:otherwise>
    </c:choose>

    <a href="home?command=go_to_add_cookie" class="btn btn-default">Add cookie</a>
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

</div>
</body>
</html>