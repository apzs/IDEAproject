package com.Interceptor;

import com.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 无名氏
 * @date 2021/9/14
 */
//权限控制拦截器
public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        判断用户是否登录
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        if (user==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
//        放行，访问目标资源
        return true;
    }
}
