<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.phoneNumbers.size() > 0}">
<div>
    <table>
        <thead>
        <tr>
            <th>№</th>
            <th>Number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.phoneNumbers}" var="phoneNumber" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${phoneNumber.number}</td>
                <td>
                    <form action="home" method="get">
                        <input type="hidden" name="command" value="go_to_edit_phone_number">
                        <input type="hidden" name="id" value=${phoneNumber.id}>
                        <button class="button" type="submit" value="edit">EDIT</button>
                    </form>
                </td>
                <td>
                    <form action="home" method="post">
                        <input type="hidden" name="command" value="delete_phone_number">
                        <input type="hidden" name="id" value=${phoneNumber.id}>
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
            <h2>There are no phone numbers yet!</h2>
        </div>
    </c:otherwise>
    </c:choose>

    <a href="home?command=go_to_add_phone_number">Add phone number</a>

</div>
</body>
</html>