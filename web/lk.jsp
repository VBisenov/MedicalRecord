<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 29.06.2019
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;  charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String s = request.getAttribute("name").toString();
    out.println(s);
%>
</body>
</html>
