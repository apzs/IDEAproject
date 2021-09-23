<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/6/27
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%--设置当前页面为错误后跳转的页面--%>
<%--设置为true后可以使用exception--%>
<%@page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>服务器正忙...</h1>
<%
    String message = exception.getMessage();
    out.print(message);
%>
</body>
</html>
