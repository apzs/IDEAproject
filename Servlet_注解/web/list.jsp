<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/6/26
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List users = new ArrayList();
    users.add(new User(1,"张三","111"));
    users.add(new User(2,"王五","121"));
    users.add(new User(3,"李四","131"));
    request.setAttribute("users",users);

%>
    <div>
        <h3>用户信息列表</h3>
        <table>
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>密码</th>
            </tr>
         <c:forEach items="${users}" var="user" varStatus="s">
             <tr>
                 <td>${user.id}</td>
                 <td>${user.username}</td>
                 <td>${user.password}</td>
             </tr>
         </c:forEach>
        </table>
    </div>
</body>
</html>
