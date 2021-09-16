package login.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 无名氏
 * @date 2021/9/14
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    //在spring-mvc中配置拦截器，在“TargetController_拦截器”类中测试
    @Override
    //在目标方法之前 执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle......");
        String param = request.getParameter("param");
        //为true时放行
        if ("yes".equals(param)){
            return true;
        }else {
            request.setAttribute("msg","没有param参数，或param参数不为yes");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
            return false;
        }
    }

    @Override
    //在目标方法之后，视图对象返回之前 执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name","lisa2");
        System.out.println("postHandle......");
    }

    @Override
    //在流程都执行完毕后 执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion......");
    }
}
