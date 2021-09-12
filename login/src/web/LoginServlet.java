package web;

import com.mysql.jdbc.StringUtils;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 无名氏
 * @Data:2021/5/18
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        HttpSession session = req.getSession();
        String checkCode_session =(String) session.getAttribute("checkCode_session");
        //删除存储在服务器的验证码字符串，防止用户登录成功后，返回到登陆界面，不改变验证码可以再次登录
        session.removeAttribute("checkCode_session");
        if(StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)
                || StringUtils.isNullOrEmpty(checkCode) || StringUtils.isNullOrEmpty(checkCode_session)){
//            req.getRequestDispatcher("/failServlet").forward(req,resp);
            req.setAttribute("msg","用户名或密码或验证码不能为空");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else if(!checkCode_session.equals(checkCode)){
            req.setAttribute("msg","验证码不正确");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else {
            User loginUser = new User(username, password);
            UserDao userDao = new UserDaoImpl();
            User user = userDao.login(loginUser);
            //判断是否存在user
            if (user!= null) {
                //登录成功
                //存储数据
                req.setAttribute("user", user);
                //请求转发
                req.getRequestDispatcher("/successServlet").forward(req, resp);
            } else {
                //登录失败
//                req.getRequestDispatcher("/failServlet").forward(req, resp);
                req.setAttribute("msg","用户名或密码不正确");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
