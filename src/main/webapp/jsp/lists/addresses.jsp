<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Address</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.addresses.size() > 0}">
<div>
    <table>
        <thead>
        <tr>
            <th>№</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.addresses}" var="address" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${address.name}</td>
                <td>
                    <form action="home" method="get">
                        <input type="hidden" name="command" value="go_to_edit_address">
                        <input type="hidden" name="id" value=${address.id}>
                        <button class="button" type="submit" value="edit">EDIT</button>
                    </form>
                </td>
                <td>
                    <form action="home" method="post">
                        <input type="hidden" name="command" value="delete_address">
                        <input type="hidden" name="id" value=${address.id}>
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
            <h2>There are no addresses yet!</h2>
        </div>
    </c:otherwise>
    </c:choose>

    <a href="home?command=go_to_add_address">Add address</a>

</div>
</body>
</html>