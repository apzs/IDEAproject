package web.UserMessageList;/**
 * @author 无名氏
 * @Data 2021/7/4
 */

import domain.PageBean;
import domain.UserMessage;
import service.UserMessageService;
import service.impl.UserMessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/searchUserMessageByPage")
public class SearchUserMessageByPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        Map<String, String[]> condition = req.getParameterMap();
        UserMessageService userMessageService = new UserMessageServiceImpl();
        PageBean<UserMessage> pageBean = userMessageService.searchUsersMessageByPage(currentPage,rows,condition);
        req.setAttribute("pageBean",pageBean);
        req.setAttribute("condition",condition);
//        req.setAttribute("totalPage",pageBean.getTotalPage());
//        req.setAttribute("totalCount",pageBean.getTotalCount());
//        req.setAttribute("userMessages",pageBean.getList());
        req.getRequestDispatcher("/userMessageList.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
