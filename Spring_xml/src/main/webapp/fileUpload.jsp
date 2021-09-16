<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/9/5
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
        文件上传三要素:
        1.表单项type="file"
        2.表单的提交方式为post
        3.enctype的属性为多部分表单
--%>
    <form action="${pageContext.request.contextPath}/user/test4" method="post" enctype="multipart/form-data">
        名称:<input type="text" name="name"><br>
        文件:<input type="file" name="file"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
