<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style>
        th {
            text-align: center;
        }

        td {
            width: 100px;
            height: 50px;
            text-align: center;
        }
    </style>

    <script>
        window.onload = function () {
            var selectAll = document.getElementById("selectAll");
            selectAll.onclick = function () {
                var selects = document.getElementsByName("id");
                for (let i = 0; i < selects.length; i++) {
                    selects[i].checked = this.checked;
                }
            }

            var deleteSelect = document.getElementById("deleteSelect");
            deleteSelect.onclick = function () {
                if (confirm("确定要删除选中的信息吗？")) {
                    var selects = document.getElementsByName("id");
                    for (var i = 0; i < selects.length; i++) {
                        //如果有一个选中就提交表单
                        if (selects[i].checked) {
                            document.getElementById("form").submit();
                            break;
                        }
                    }
                }
            }
        }

        function del(id) {
            if (confirm("您确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/deleteUserMessageServlet?id=" + id;
            }
        }
        function change() {

        }
    </script>

</head>
<body>
<div class="container">
    <header class="form-inline" style="margin-bottom: 50px">
        <h1 style="text-align: center">用户信息表</h1>
        <form class="form-inline"
              action="${pageContext.request.contextPath}/searchUserMessageByPage?currentPage=${pageBean.currentPage}&rows=${pageBean.rows}" method="post">
            <div style="float: left">
                <div class="form-group">
                    <label for="name">姓名</label>
                    <input type="text" class="form-control" id="name" name="name" value="${condition.name[0]}">
                </div>
                <div class="form-group">
                    <label for="tel">电话号码</label>
                    <input type="text" class="form-control" id="tel" name="tel" value="${condition.tel[0]}">
                </div>
                <div class="form-group">
                    <label for="e_mail">邮箱</label>
                    <input type="text" class="form-control" id="e_mail" name="e_mail" value="${condition.e_mail[0]}">
                </div>
                <button type="submit" class="btn btn-default" style="margin-right: 50px;">查询</button>
            </div>
        </form>
        <div style="float: left">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/userMessage.jsp?userType=root"
               name="change">添加联系人</a>
            <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelect" name="change">删除选中</a>
        </div>
    </header>
    <form class="form-inline" id="form" style="float: left"
          action="${pageContext.request.contextPath}/deleteUserMessageServlet" method="post">
        <table class="table table-bordered table-hover">
            <tr class="warning">
                <th><input type="checkbox" id="selectAll"></th>
                <th>id</th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话号码</th>
                <th>QQ号</th>
                <th>邮箱</th>
                <th width="200px">
                </th>
            </tr>
            <c:forEach items="${pageBean.list}" var="userMessage" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="id" value="${userMessage.id}"></td>
                    <td>${userMessage.id}</td>
                    <td>${userMessage.name}</td>
                    <td>${userMessage.gender}</td>
                    <td>${userMessage.tel}</td>
                    <td>${userMessage.qq}</td>
                    <td>${userMessage.e_mail}</td>
                    <td>
                        <a class="btn btn-default"
                           href="${pageContext.request.contextPath}/searchUserMessage?id=${userMessage.id}&userType=root"
                           name="change" style="float: left;margin-left: 20px">修改</a>
                        <a class="btn btn-default" href="javascript:del(${userMessage.id});" name="delete"
                           style="float: right;margin-right: 20px">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <nav>
        <div style="float: left">
            <h3>查询到${pageBean.totalCount}条数据,总共${pageBean.totalPage}页</h3>
        </div>
        <div style="float:right">
            <ul class="pagination">
                <c:if test="${pageBean.currentPage == 1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${pageBean.currentPage != 1}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/searchUserMessageByPage?currentPage=${pageBean.currentPage-1}&rows=10&name=${condition.name[0]}&tel=${condition.tel[0]}&e_mail=${condition.e_mail[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                    <c:if test="${pageBean.currentPage == i}">
                        <li class="active">
                    </c:if>
                    <c:if test="${pageBean.currentPage != i}">
                        <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/searchUserMessageByPage?currentPage=${i}&rows=10&name=${condition.name[0]}&tel=${condition.tel[0]}&e_mail=${condition.e_mail[0]}">${i}</a>
                    </li>

                </c:forEach>
                <%--                <li class="active"><a href="#">2 <span class="sr-only">(current)</span></a></li>--%>
                <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                    <li class="disabled" style="margin-right: 150px">
                </c:if>
                <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                    <li style="margin-right: 150px">
                </c:if>
                <a href="${pageContext.request.contextPath}/searchUserMessageByPage?currentPage=${pageBean.currentPage+1}&rows=10&name=${condition.name[0]}&tel=${condition.tel[0]}&e_mail=${condition.e_mail[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>
