<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/6/27
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%--设置文件字符编码--%>
<%@page pageEncoding="utf-8"%>
<%--如果当前页面出现错误，跳转到指定页面--%>
<%@page errorPage="error.jsp" %>
<%--设置当前页面是否是错误后的跳转界面--%>
<%@page isErrorPage="false" %>
<%--值为true时不使用EL表达式，遇见EL表达式原样展示--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--   忽略单个EL表达式，在前面加\  --%>
    \${3>4}
    ${3>4}
</body>
</html>
