<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sweets</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.sweets.size() > 0}">
<div>
    <table>
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
        <c:forEach items="${requestScope.sweets}" var="sweets" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${sweets.price}</td>
                <td>${sweets.type}</td>
                <td>${sweets.weight}</td>
                <td>${sweets.composition}</td>
                <td style="display:none">${sweets.brandId}</td>
                <td>${sweets.brandName}</td>
                <td style="display:none">${sweets.storeId}</td>
                <td>${sweets.storeName}</td>
                <td style="display:none">${sweets.supplierId}</td>
                <td>${sweets.supplierName}</td>
                <td>
                    <form action="home" method="get">
                        <input type="hidden" name="command" value="go_to_edit_sweets">
                        <input type="hidden" name="id" value=${sweets.id}>
                        <button class="button" type="submit" value="edit">EDIT</button>
                    </form>
                </td>
                <td>
                    <form action="home" method="post">
                        <input type="hidden" name="command" value="delete_sweets">
                        <input type="hidden" name="id" value=${sweets.id}>
                        <button class="button" type="submit" value="delete">DELETE</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:when>
    <c:otherwise>
        <div>
            <h2>There are no sweets yet!</h2>
        </div>
    </c:otherwise>
    </c:choose>

    <a href="home?command=go_to_add_sweets">Add sweets</a>

</div>
</body>
</html>