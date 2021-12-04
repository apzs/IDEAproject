<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/9/20
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加用户信息</h1>
    <form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
        账户名称:<input type="text" name="name">  <br>
        账户金额:<input type="text" name="account"> <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
