package web.UserMessageList;
/**
 * @author 无名氏
 * @Data 2021/7/3
 */

import domain.UserMessage;
import service.UserMessageService;
import service.impl.UserMessageServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/searchUserMessage")
public class SearchUserMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //用户类型
        String  userType = req.getParameter("userType");
        UserMessageService userMessageService = new UserMessageServiceImpl();
        UserMessage userMessage = userMessageService.searchUserMessage(Integer.parseInt(id));
        req.setAttribute("userMessage",userMessage);
        req.setAttribute("id",userMessage.getId());
        req.setAttribute("userType",userType);
        req.getRequestDispatcher("/userMessage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
