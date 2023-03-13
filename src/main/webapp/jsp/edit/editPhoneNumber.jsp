<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Edit phone number</title>
</head>
<body>
<div>
    <h2>Edit phone number</h2>
    <form method="post" action="home">
        <input type="hidden" name="command" value="update_phone_number">
        <input type="hidden" name="id" value=${requestScope.phoneNumber.id}>
        <div>
            <div>
                <input id="numberInput" placeholder="Enter number" type="text" name="number" value="${requestScope.phoneNumber.number}">
            </div>
        </div>
        <button type="submit" name="command" value="update_phone_number">UPDATE PHONE NUMBER</button>
        <a href="home?command=read_phone_number">CANCEL</a>
    </form>
</div>
</body>
</html>
