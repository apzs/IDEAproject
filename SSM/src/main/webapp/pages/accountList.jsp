<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/9/20
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
        <h1>展示账户信息列表</h1>
  <table>
      <tr>
          <th>账户id</th>
          <th>账户名称</th>
          <th>账户金额</th>
      </tr>
      <c:forEach items="${accountList}" var="account">
          <tr>
              <td>${account.id}</td>
              <td>${account.name}</td>
              <td>${account.account}</td>
          </tr>
      </c:forEach>
  </table>
  </body>
</html>
