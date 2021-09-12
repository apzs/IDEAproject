<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        #submit{
            margin-right: 15px;
            margin-left: 12px;
            width: 80px;
        }
    </style>
    <script>
        window.onload = function () {
            var reChange =  document.getElementById("reCharge");
            reChange.onclick = function () {
                location.reload();
            }
            var back =  document.getElementById("back");
            back.onclick = function () {
                history.back();
            }

            var sub = document.getElementById("sub");
            sub.onclick = function () {
                var name = document.getElementsByName("name")[0].value;
                var gender = document.getElementsByName("gender");
                var flag = false;
                for (let i = 0; i < gender.length; i++) {
                    if (gender[i].checked){
                        flag = true;
                    }
                }
                var tel = document.getElementsByName("tel")[0].value;
                var  qq = document.getElementsByName("qq")[0].value;
                var e_mail = document.getElementsByName("e_mail")[0].value;
                var address = document.getElementsByName("address")[0].value;
                if (check(name) && flag && check(tel) && check(qq) && check(e_mail) && check(address)){
                    // alert(document.getElementById("form"));
                    alert("修改成功");
                    document.getElementById("form").submit();
                }else {
                    alert("请将信息填写完整");
                }
            }
        }
        function check(str){
            var newStr = trimStr(str);
            return !(newStr == null || newStr == "");

        }
        function trimStr(str){
            return str.replace(/(^\s*)|(\s*$)/g,"");
        }
    </script>
</head>
<body>
<div class="container" style="width: 500px;">
    <h3 style="text-align: center;">用户信息</h3>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/addUserMessage" method="post" id="form">
<%--        隐藏域--%>
        <input type="text" hidden name="id" value="${id}"/>
<%--    用户类型--%>
        <input type="text" hidden name="userType" value="${userType}"/>
        <div class="form-group">
            <label class="col-xs-2 control-label" for="name">姓名：</label>
            <div class="col-xs-10">
                <input class="form-control" id="name" type="text" name="name" value="${userMessage.name}">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-2 control-label">性别：</label>
            <label style="width: 10px"></label>
<%--            使用jstl标签判断用户性别--%>
            <c:if test="${userMessage.gender  == '男'}">
                <input type="radio" name="gender" value="男" checked>
                <label style="width: 50px;line-height: 30px">男</label>
                <input type="radio" name="gender" value="女">
                <label style="line-height: 30px">女</label>
            </c:if>

            <c:if test="${userMessage.gender  == '女'}">
                <input type="radio" name="gender" value="男">
                <label style="width: 50px;line-height: 30px">男</label>
                <input type="radio" name="gender" value="女" checked>
                <label style="line-height: 30px">女</label>
            </c:if>

            <c:if test="${userMessage.gender  == null}">
                <input type="radio" name="gender" value="男">
                <label style="width: 50px;line-height: 30px">男</label>
                <input type="radio" name="gender" value="女">
                <label style="line-height: 30px">女</label>
            </c:if>
        </div>

        <div class="form-group">
            <label class="col-xs-2 control-label" style="padding: 0;line-height: 32px">电话号码：</label>
            <div class="col-xs-10">
                <input class="form-control" type="text" name="tel" value="${userMessage.tel}">
            </div>
        </div>

        <div class="form-group">
            <label class="col-xs-2 control-label">QQ：</label>
            <div class="col-xs-10">
                <input class="form-control" type="text" name="qq" value="${userMessage.qq}">
            </div>
        </div>

        <div class="form-group">
            <label class="col-xs-2 control-label" style="padding: 0;line-height: 32px">E-mail：</label>
            <div class="col-xs-10">
                <input class="form-control" type="text" name="e_mail" value="${userMessage.e_mail}">
            </div>
        </div>

        <div class="form-group">
            <label class="col-xs-2 control-label" style="padding: 0;line-height: 32px">详细地址：</label>
            <div class="col-xs-10">
                <textarea placeholder="详细地址" name="address">${userMessage.address}</textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-10">
                <label class="col-sm-2 control-label" style="margin-right: 30px"></label>
                <input type="button" class="btn btn-success" id="sub" value="确定"/>
                <input type="button" class="btn" style="margin-right: 12px;width: 80px;" id="reCharge" value="重置"/>
                <input type="button" class="btn" style="width: 80px;" id="back" value="返回"/>
            </div>
        </div>
    </form>
</div>
<div>
</div>
</body>
</html>
