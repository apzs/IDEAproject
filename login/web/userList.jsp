<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <style>
        th{
            text-align: center;
        }
        td{
            width: 100px;
            height: 50px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container" style="width: 1000px;">
        <h3 align="center">用户表</h3>
        <table class="table table-bordered table-hover">
            <tr class="warning">
                <th><input type="checkbox" name="selectAll"></th>
                <th>id</th>
                <th>用户名</th>
                <th>密码</th>
                <th></th>
            </tr>
         <c:forEach items="${users}" var="user" varStatus="s">
             <tr>
                 <td style="text-align: center"><input type="checkbox" name="select"></td>
                 <td>${user.id}</td>
                 <td>${user.username}</td>
                 <td>${user.password}</td>
                 <td>
                     <input type="button" name="change" value="修改">
                     <input type="button" name="delete" value="删除">
                 </td>
             </tr>
         </c:forEach>
        </table>
    </div>
</body>
</html>
