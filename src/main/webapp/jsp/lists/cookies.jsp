<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cookie</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.cookies.size() > 0}">
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
    <c:forEach items="${requestScope.cookies}" var="element" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td>${element.price}</td>
        <td>${element.type}</td>
        <td>${element.weight}</td>
        <td>${element.composition}</td>
        <td style="display:none">${element.brandId}</td>
        <td>${element.brandName}</td>
        <td style="display:none">${element.storeId}</td>
        <td>${element.storeName}</td>
        <td style="display:none">${element.supplierId}</td>
        <td>${element.supplierName}</td>
        <td>
          <form action="home" method="get">
            <input type="hidden" name="command" value="go_to_edit_cookie">
            <input type="hidden" name="id" value=${element.id}>
            <button class="button" type="submit" value="edit">EDIT</button>
          </form>
        </td>
        <td>
          <form action="home" method="post">
            <input type="hidden" name="command" value="delete_cookie">
            <input type="hidden" name="id" value=${element.id}>
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
      <h2>There are no cookies yet!</h2>
    </div>
  </c:otherwise>
  </c:choose>

  <a href="home?command=go_to_add_cookie">Add cookie</a>

</div>
</body>
</html>