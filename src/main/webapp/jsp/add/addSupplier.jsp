<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
  <title>New supplier</title>
</head>
<body>
<div>
  <h2>Add supplier</h2>
  <form method="post" action="home">
    <input type="hidden" name="command" value="create_supplier">
    <div>
      <div>
        <input id="nameInput" placeholder="Enter name" type="text" name="name">
      </div>
      <div>
        <input id="contactPersonInput" placeholder="Enter contact person" type="text" name="contactPerson">
      </div>
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
    <button type="submit" name="command" value="create_supplier">CREATE SUPPLIER</button>
    <a href="home?command=read_supplier">CANCEL</a>
  </form>
</div>
</body>
</html>