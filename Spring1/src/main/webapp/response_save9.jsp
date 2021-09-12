<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/9/5
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/save9" method="post">
        <label>姓名:</label>  <input type="text" name="userList[0].username"><br>
        <label>年龄:</label>  <input type="text" name="userList[0].age"><br>
        <label>姓名:</label>  <input type="text" name="userList[1].username"><br>
        <label>年龄:</label>   <input type="text" name="userList[1].age"><br>
        <label>姓名:</label>  <input type="text" name="userList[2].username"><br>
        <label>年龄:</label>   <input type="text" name="userList[2].age"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
