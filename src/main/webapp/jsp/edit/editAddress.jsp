<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
  <title>Edit address</title>
</head>
<body>
<div>
  <h2>Edit address</h2>
  <form method="post" action="home">
    <input type="hidden" name="command" value="update_address">
    <input type="hidden" name="id" value=${requestScope.address.id}>
    <div>
      <div>
        <input id="nameInput" placeholder="Enter name" type="text" name="name" value="${requestScope.address.name}">
      </div>
    </div>
    <button type="submit" name="command" value="update_address">UPDATE BRAND</button>
    <a href="home?command=read_address">CANCEL</a>
  </form>
</div>
</body>
</html>
