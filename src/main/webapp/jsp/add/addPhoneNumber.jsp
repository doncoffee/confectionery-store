<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
  <title>New phone number</title>
</head>
<body>
<div>
  <h2>Add phone number</h2>
  <form method="post" action="home">
    <input type="hidden" name="command" value="create_phone_number">
    <div>
      <div>
        <input id="numberInput" placeholder="Enter number" type="text" name="number">
      </div>
    </div>
    <button type="submit" name="command" value="create_phone_number">CREATE PHONE NUMBER</button>
    <a href="home?command=read_phone_number">CANCEL</a>
  </form>
</div>
</body>
</html>
