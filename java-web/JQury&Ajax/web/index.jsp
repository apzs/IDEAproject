<%--
  Created by IntelliJ IDEA.
  User: 无名氏
  Date: 2021/6/14
  Time: 17:41
  To change this template use File | Settings | File Templates.
  异步检查用户名是否已经存在
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            //绑定失去焦点事件
            $("#username").blur(
                function () {
                    //获取username文本输入框的值
                    var username = $(this).val();
                    //发送ajax请求
                    //期望服务器响应格式，{"userExist":true,"msg":"用户名已存在"}
                    //                {"userExist":false,"msg":"用户名可用"}
                    $.get("findUserServlet", {username: username}, function (data) {
                            var sp = $("#s_username");
                            if (data.userExist) {
                                sp.css("color","red");
                                sp.html(data.msg);
                            } else {
                                sp.css("color","green");
                                sp.html(data.msg);
                            }
                        }, "json"
                    )
                }
            )
        })
    </script>
</head>
<body>
<form>
    <input type="text" id="username" name="username" placeholder="请输入用户名">
    <span id="s_username"></span>
    <br>
    <input type="text" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="注册"><br>
</form>
</body>
</html>
