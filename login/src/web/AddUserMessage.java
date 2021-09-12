package web;/**
 * @author 无名氏
 * @Data 2021/7/2
 */

import domain.UserMessage;
import org.apache.commons.beanutils.BeanUtils;
import service.UserMessageService;
import service.impl.UserMessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addUserMessage")
public class AddUserMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userType = req.getParameter("userType");
        Map<String, String[]> userMap = req.getParameterMap();
        Map<String,String[]> map = new HashMap<>(userMap);
        map.remove("userType");
        UserMessage userMessage = new UserMessage();
        try {
            BeanUtils.populate(userMessage, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        System.out.println(userMessage);
        UserMessageService userMessageService = new UserMessageServiceImpl();
        userMessageService.addUserMessage(userMessage);
//        resp.getWriter().write("<script>alert('success')</script>");
        if ("root".equals(userType)) {
            //重新查询所有用户信息
            resp.sendRedirect(req.getContextPath()+"/searchUserMessageByPage");
        }else {
            req.setAttribute("userMessage",userMessage);
            req.getRequestDispatcher("/userMessage.jsp").forward(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
