package web.UserMessageList;/**
  *@author 无名氏
  *@Data 2021/7/3
  */

import service.UserMessageService;
import service.impl.UserMessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserMessageServlet")
public class DeleteUserMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] id = req.getParameterValues("id");
        int[] ids = new  int[id.length];
        for (int i = 0; i < id.length; i++) {
            ids[i] = Integer.parseInt(id[i]);
        }
        UserMessageService userMessageService = new UserMessageServiceImpl();
        userMessageService.deleteUserMessage(ids);
        resp.sendRedirect(req.getContextPath()+"/searchUserMessageByPage");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
