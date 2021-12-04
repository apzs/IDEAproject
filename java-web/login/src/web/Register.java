package web;

import com.mysql.jdbc.StringUtils;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 无名氏
 * @Data 2021/6/29
 */
@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password1) || StringUtils.isNullOrEmpty(password2)){
            req.setAttribute("msg","用户名或密码不能为空");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }else if(!password1.equals(password2)){
            req.setAttribute("msg","两次输入密码不一致");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }else {
            User user = new User(username,password1);
            UserService userService = new UserServiceImpl();
            boolean add = userService.add(user);
            if (add){
                resp.sendRedirect(req.getContextPath() + "/userMessage.jsp");
            }else {
                req.setAttribute("msg","用户名已存在");
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
