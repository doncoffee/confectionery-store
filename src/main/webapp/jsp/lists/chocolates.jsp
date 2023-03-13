<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Chocolate</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.chocolates.size() > 0}">
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
    <c:forEach items="${requestScope.chocolates}" var="chocolate" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td>${chocolate.price}</td>
        <td>${chocolate.type}</td>
        <td>${chocolate.weight}</td>
        <td>${chocolate.composition}</td>
        <td style="display:none">${chocolate.brandId}</td>
        <td>${chocolate.brandName}</td>
        <td style="display:none">${chocolate.storeId}</td>
        <td>${chocolate.storeName}</td>
        <td style="display:none">${chocolate.supplierId}</td>
        <td>${chocolate.supplierName}</td>
        <td>
          <form action="home" method="get">
            <input type="hidden" name="command" value="go_to_edit_chocolate">
            <input type="hidden" name="id" value=${chocolate.id}>
            <button class="button" type="submit" value="edit">EDIT</button>
          </form>
        </td>
        <td>
          <form action="home" method="post">
            <input type="hidden" name="command" value="delete_chocolate">
            <input type="hidden" name="id" value=${chocolate.id}>
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
      <h2>There are no chocolates yet!</h2>
    </div>
  </c:otherwise>
  </c:choose>


  <a href="home?command=go_to_add_chocolate">Add chocolate</a>

</div>
</body>
</html>