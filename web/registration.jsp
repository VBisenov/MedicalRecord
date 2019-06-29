<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 09.05.2019
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action = "reg" method="post">
    Name: <input type = "text" name = "name"><br>
    Surname: <input type = "text" name = "surName"><br>
    Father Name: <input type = "text" name = "fatherName"><br>
    Address: <input type = "text" name = "address"><br>
    Phone number: <input type="text" name="phoneNumber"><br>
    Password: <input type="text" name="pass"><br>
    Password repeat: <input type="text" name="passRepeat"><br>
    <input type="submit">
</form>
<a href="getemployees"><button>Go back</button></a>
</body>
</html>
