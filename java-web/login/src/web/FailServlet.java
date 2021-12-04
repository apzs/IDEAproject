package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Data:2021/5/18
 */
@WebServlet("/failServlet")
public class FailServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //给页面写一句话
        //设置编码
       resp.setContentType("text/html;charset=utf-8");
        //输出
        resp.getWriter().write("<h1>登陆失败，用户名或密码或验证码错误,3秒后自动跳转到登录界面</h1> + <script>setTimeout(function (){ location.href='index.jsp'; },3000); </script>");
//        请求转发后再重定向容易发生异常
//        resp.sendRedirect("http://localhost/login/");
//          req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
