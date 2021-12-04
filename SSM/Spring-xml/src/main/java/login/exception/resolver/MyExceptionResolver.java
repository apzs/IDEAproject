package login.exception.resolver;

import login.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 无名氏
 * @date 2021/9/15
 * 我的异常处理器，需要在spring-mvc.xml中配置
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e  报异常的异常对象
     * @return   返回值ModelAndView：要跳转的错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if (e instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }else if (e instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }else {
            modelAndView.addObject("info","其他类型异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
