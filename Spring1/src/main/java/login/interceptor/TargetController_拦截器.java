package login.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 无名氏
 * @date 2021/9/14
 */
@Controller
@RequestMapping("target")
public class TargetController_拦截器 {
//    http://localhost:8080/login/target/test
//    http://localhost:8080/login/target/test?param=yes
    @RequestMapping("/test")
    public ModelAndView show(ModelAndView modelAndView){
        System.out.println("目标资源执行");
        modelAndView.addObject("name","lisa");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
