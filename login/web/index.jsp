<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>

    <style type="text/css">
        * {
            margin: 0 auto;
            padding: 0;
        }

        #div1 {
            padding-top: 200px;
            width: 200px;
            margin: 0 auto;
        }
        #img{
            margin-left: 10px;
            border-radius: 5px;
        }
        #msg{
            text-align: center;
            font-size: 20px;
            color: red;
            width: 200px;
            height: 60px;
            background-color: #a6e1ec;
        }
    </style>
    <script>
        window.onload = function () {
            var img = document.getElementById("img");
            img.onclick = function () {
                this.src = "/login/checkCode?time=" + new Date().getTime();
            }

            if(${msg eq  null}){
                var msg = document.getElementById("msg");
                msg.hidden = true;
            }
        }
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <div style="width: 370px;height: 57px;">
        <div style="width: 300px;float: left">
            <h3 style="text-align: center" >欢迎登录</h3>
        </div>
        <div style="width: 70px;height:56px;line-height: 80px;float: left">
            <a href="${pageContext.request.contextPath}/register.jsp">没有账号？</a>
        </div>
    </div>
    <form action="/login/loginServlet" method="post">
        <div class="form-group">
            <label>用户名：</label>
            <input aria-describedby="sizing-addon1" class="form-control" placeholder="请输入用户名"  name="username" type="text">
        </div>

        <div class="form-group">
            <label>密码：</label>
            <input aria-describedby="basic-addon1" class="form-control" placeholder="请输入密码" name="password" type="password">
        </div>

        <div class="form-group">
            <label style="float: left;line-height: 39px">验证码：</label>
            <input aria-describedby="basic-addon1" class="form-control" placeholder="请输入验证码" style="float: left;width: 200px;" name="checkCode" type="text">
            <img id="img" src="/login/checkCode"/>
        </div>
        <br>
        <hr>
        <div  class="form-group" style="text-align: center">
            <input class="btn btn-primary" style="width: 100px" type="submit" value="登录">
        </div>
    </form>

</div>

<div id="msg">${msg}</div>

</body>
</html>
