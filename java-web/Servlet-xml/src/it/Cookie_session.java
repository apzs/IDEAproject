package it;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 无名氏
 * @Data:2021/6/27
 */
@WebServlet("/cookie_session")
public class Cookie_session extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("msg","hello cookie");
        //设置客户端关闭后cookie存活时间(以秒为单位)， 0为删除 负数为客户端关闭后不保存
        cookie1.setMaxAge(20);
        cookie1.setPath("/*");
        resp.addCookie(cookie1);
        Cookie[] cookies = req.getCookies();
        if (cookies!=null && cookies.length!=0){
            for (Cookie cookie : cookies) {
                System.out.println(cookie1.getName()+ ":" + cookie1.getValue());
            }
        }

        HttpSession session = req.getSession();
        session.setAttribute("msg","hello session");
        System.out.println(session.getAttribute("msg"));
        //把session写进cookie使客户端关闭后，再次请求能获取这个session
        Cookie cookie2 = new Cookie("JSESSIONID",session.getId());
        cookie2.setMaxAge(20);
        resp.addCookie(cookie2);
        //清除name为“msg”的session对象
        session.removeAttribute("msg");
        //销毁session
        session.invalidate();
        //客户端在30分钟内未响应，则自动销毁session，可以在web.xml中的session-config配置
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
