<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/9/5
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        var userList = new Array();
        userList.push({username:"lisa",age:18});
        userList.push({username:"lisa2",age:20});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/save10",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
