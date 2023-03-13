<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.stores.size() > 0}">
<div>
    <table>
        <thead>
        <tr>
            <th>№</th>
            <th>Address</th>
            <th>PhoneNumber</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.stores}" var="store" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td style="display:none">${store.addressId}</td>
                <td>${store.addressName}</td>
                <td style="display:none">${store.phoneNumberId}</td>
                <td>${store.phoneNumber}</td>
                <td>
                    <form action="home" method="get">
                        <input type="hidden" name="command" value="go_to_edit_store">
                        <input type="hidden" name="id" value=${store.id}>
                        <button class="button" type="submit" value="edit">EDIT</button>
                    </form>
                </td>
                <td>
                    <form action="home" method="post">
                        <input type="hidden" name="command" value="delete_store">
                        <input type="hidden" name="id" value=${store.id}>
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
            <h2>There are no stores yet!</h2>
        </div>
    </c:otherwise>
    </c:choose>

    <a href="home?command=go_to_add_store">Add store</a>

</div>
</body>
</html>