<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Edit sweets</title>
</head>
<body>
<div>
    <h2>Edit sweets</h2>
    <form method="post" action="home">
        <input type="hidden" name="command" value="update_sweets">
        <input type="hidden" name="id" value=${requestScope.sweets.id}>
        <div>
            <div>
                <input id="priceInput" placeholder="Enter price" type="text" name="price" value="${requestScope.sweets.price}">
            </div>
            <div>
                <input id="typeInput" type="text" placeholder='Enter type' name="type" value="${requestScope.sweets.type}">
            </div>
            <div>
                <input id="weightInput" type="text" placeholder='Enter weight' name="weight" value="${requestScope.sweets.weight}">
            </div>
            <div>
                <input id="compositionInput" type="text" placeholder='Enter composition' name="composition" value="${requestScope.sweets.composition}">
            </div>
            <label>Brand:
                <div>
                    <select id="brandId" name="brandId" required>
                        <c:forEach var="brand" items="${requestScope.brands}">
                            <option value="${brand.id}">${brand.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </label>
            <label>Store:
            <div>
                <select id="storeId" name="storeId" required>
                    <c:forEach var="store" items="${requestScope.stores}">
                        <option value="${store.addressId}">${store.addressName}</option>
                    </c:forEach>
                </select>
            </div>
            </label>
            <label>Supplier:
            <div>
                <select id="supplierId" name="supplierId" required>
                    <c:forEach var="supplier" items="${requestScope.suppliers}">
                        <option value="${supplier.id}">${supplier.name}</option>
                    </c:forEach>
                </select>
            </div>
            </label>
        </div>
        <button type="submit" name="command" value="update_sweets">UPDATE SWEETS</button>
        <a href="home?command=read_sweets">CANCEL</a>
    </form>
</div>
</body>
</html>