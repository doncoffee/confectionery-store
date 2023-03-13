<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Edit brand</title>
</head>
<body>
<div>
    <h2>Edit brand</h2>
    <form method="post" action="home">
        <input type="hidden" name="command" value="update_brand">
        <input type="hidden" name="id" value=${requestScope.brand.id}>
        <div>
            <div>
                <input id="nameInput" placeholder="Enter name" type="text" name="name" value="${requestScope.brand.name}">
            </div>
        </div>
        <button type="submit" name="command" value="update_brand">UPDATE BRAND</button>
        <a href="home?command=read_brand">CANCEL</a>
    </form>
</div>
</body>
</html>