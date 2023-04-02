<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Supplier</title>
    <link rel="stylesheet" href="./../../css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
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
        <h1>Suppliers</h1>
    </div>
    <div class="main">
        <div class="search-div">
            <form method="get">
                <input type="hidden" name="command" value="read_supplier">
                <label for="search">Search:</label>
                <input type="text" name="search" id="search" value="${requestScope.search}">
                <button class="button btn btn-default" type="submit">Submit</button>
            </form>
        </div>
        <c:choose>
            <c:when test="${requestScope.suppliers.size() > 0}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>№</th>
                        <th>Name</th>
                        <th>Contact Person</th>
                        <th>Address</th>
                        <th>PhoneNumber</th>
                        <th colspan=2>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.suppliers}" var="supplier" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td>${supplier.name}</td>
                            <td>${supplier.contactPerson}</td>
                            <td style="display:none">${supplier.addressId}</td>
                            <td>${supplier.addressName}</td>
                            <td style="display:none">${supplier.phoneNumberId}</td>
                            <td>${supplier.phoneNumber}</td>
                            <td>
                                <form action="home" method="get">
                                    <input type="hidden" name="command" value="go_to_edit_supplier">
                                    <input type="hidden" name="id" value=${supplier.id}>
                                    <input type="hidden" name="itemsPerPage" value="${requestScope.itemsPerPage}">
                                    <input type="hidden" name="currentPage" value="${requestScope.currentPage}">
                                    <button class="button btn btn-default" type="submit" value="edit">EDIT</button>
                                </form>
                            </td>
                            <td>
                                <form action="home" method="post">
                                    <input type="hidden" name="command" value="delete_supplier">
                                    <input type="hidden" name="id" value=${supplier.id}>
                                    <input type="hidden" name="itemsPerPage" value="${requestScope.itemsPerPage}">
                                    <input type="hidden" name="currentPage" value="${requestScope.currentPage}">
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
                    <h2 class="catalog-name">There are no suppliers yet!</h2>
                </div>
            </c:otherwise>
        </c:choose>

        <div class="pagination-block">
            <div class="pagination">
                <c:if test="${currentPage > 1}">
                    <form method="get" action="home">
                        <input type="hidden" name="command" value="read_supplier">
                        <input type="hidden" name="search" value="${requestScope.search}">
                        <input type="hidden" name="itemsPerPage" value="${itemsPerPage}">
                        <input type="hidden" name="currentPage" value="${currentPage - 1}">
                        <button class="page-link" type="submit">Previous</button>
                    </form>
                </c:if>
                <c:forEach begin="1" end="${totalItems}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <a class="current-page">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <form method="get" action="home">
                                    <input type="hidden" name="command" value="read_supplier">
                                    <input type="hidden" name="search" value="${requestScope.search}">
                                    <input type="hidden" name="itemsPerPage" value="${itemsPerPage}">
                                    <input type="hidden" name="currentPage" value="${i}">
                                    <button type="submit">${i}</button>
                                </form>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${currentPage < totalItems}">
                    <form method="get" action="home">
                        <input type="hidden" name="command" value="read_supplier">
                        <input type="hidden" name="search" value="${requestScope.search}">
                        <input type="hidden" name="itemsPerPage" value="${itemsPerPage}">
                        <input type="hidden" name="currentPage" value="${currentPage + 1}">
                        <button class="page-link" type="submit">Next</button>
                    </form>
                </c:if>
            </div>

            <form class="form" method="get" action="home">
                <input type="hidden" name="command" value="read_supplier">
                <input type="hidden" name="search" value="${requestScope.search}">
                <input type="hidden" name="currentPage" value="1">
                <select class="form select" id="records" name="itemsPerPage" onchange="this.form.submit()">
                    <option value="" selected disabled hidden>Records quantity</option>
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                </select>
            </form>
        </div>
        <form action="home" method="get">
            <input type="hidden" name="command" value="go_to_add_supplier">
            <input type="hidden" name="itemsPerPage" value="${requestScope.itemsPerPage}">
            <input type="hidden" name="currentPage" value="${requestScope.currentPage}">
            <button class="button btn btn-default" type="submit" value="edit">Add supplier</button>
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

</div>
</div>
</body>
</html>