package web;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 无名氏
 * @Data:2021/5/18
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //给页面写一句话
        User user =(User) req.getAttribute("user");
        String name = user.getUsername();
        //设置编码
       resp.setContentType("text/html;charset=utf-8");
       if("admin".equals(name)){
           req.getRequestDispatcher("/allUser.jsp").forward(req,resp);
       }else if ("root".equals(name)){
           //查询所有用户信息
           req.getRequestDispatcher("/searchUserMessageByPage").forward(req,resp);
       }else {
           req.setAttribute("id",user.getId());
           req.setAttribute("userType","generalUser");
           req.getRequestDispatcher("/userMessage.jsp").forward(req,resp);
       }
       /* //输出
        resp.getWriter().write("<h1 style=\"text-align: center\">登陆成功！\" "+name+" \"，欢迎您\n" +
                "    <br>\n" +
                "    3秒后跳转到查询页面\n" +
                "</h1>" +
                " <script>\n" +
                "      setTimeout(function (){\n" +
                "        location.href='allUser.jsp';\n" +
                "      },3000);\n" +
                "    </script>");*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
