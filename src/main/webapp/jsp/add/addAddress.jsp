<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
  <title>New address</title>
</head>
<body>
<div>
  <h2>Add address</h2>
  <form method="post" action="home">
    <input type="hidden" name="command" value="create_address">
    <div>
      <div>
        <input id="nameInput" placeholder="Enter name" type="text" name="name">
      </div>
    </div>
    <button type="submit" name="command" value="create_address">CREATE ADDRESS</button>
    <a href="home?command=read_address">CANCEL</a>
  </form>
</div>
</body>
</html>
