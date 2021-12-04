package web.UserMessageList;/**
 * @author 无名氏
 * @Data 2021/7/3
 */

import dao.UserMessageDao;
import dao.impl.UserMessageDaoImpl;
import domain.UserMessage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/userMessageListServlet")
public class UserMessageListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserMessageDao umDao =new UserMessageDaoImpl();
        List<UserMessage> userMessages = umDao.findAllUserMessage();
        req.setAttribute("userMessages",userMessages);
        req.getRequestDispatcher("/userMessageList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
