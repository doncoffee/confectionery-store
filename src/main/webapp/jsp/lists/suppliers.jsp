<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Supplier</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.suppliers.size() > 0}">
<div>
  <table>
    <thead>
    <tr>
      <th>№</th>
      <th>Name</th>
      <th>Contact Person</th>
      <th>Address</th>
      <th>PhoneNumber</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.suppliers}" var="supplier" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td>${supplier.name}</td>
        <td>${supplier.contactPerson}</td>
        <td style="display:none">${supplier.addressId}</td>
        <td>${supplier.addressName}</td>
        <td style="display:none">${supplier.phoneNumberId}</td>
        <td>${supplier.phoneNumber}</td>
        <td>
          <form action="home" method="get">
            <input type="hidden" name="command" value="go_to_edit_supplier">
            <input type="hidden" name="id" value=${supplier.id}>
            <button class="button" type="submit" value="edit">EDIT</button>
          </form>
        </td>
        <td>
          <form action="home" method="post">
            <input type="hidden" name="command" value="delete_supplier">
            <input type="hidden" name="id" value=${supplier.id}>
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
      <h2>There are no suppliers yet!</h2>
    </div>
  </c:otherwise>
  </c:choose>

  <a href="home?command=go_to_add_supplier">Add supplier</a>

</div>
</body>
</html>