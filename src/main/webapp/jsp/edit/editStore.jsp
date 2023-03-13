<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Edit store</title>
</head>
<body>
<div>
    <h2>Edit store</h2>
    <form method="post" action="home">
        <input type="hidden" name="command" value="update_store">
        <input type="hidden" name="id" value=${requestScope.store.id}>
        <div>
            <label>Address:
            <div>
                <select id="addressId" name="addressId" required>
                    <c:forEach var="address" items="${requestScope.addresses}">
                        <option value="${address.id}">${address.name}</option>
                    </c:forEach>
                </select>
            </div>
            </label>
            <label>Phone number:
            <div>
                <select id="phoneNumberId" name="phoneNumberId" required>
                    <c:forEach var="phoneNumber" items="${requestScope.phoneNumbers}">
                        <option value="${phoneNumber.id}">${phoneNumber.number}</option>
                    </c:forEach>
                </select>
            </div>
            </label>
        </div>
        <button type="submit" name="command" value="update_store">UPDATE STORE</button>
        <a href="home?command=read_store">CANCEL</a>
    </form>
</div>
</body>
</html>