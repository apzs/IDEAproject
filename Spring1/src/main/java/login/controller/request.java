package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 无名氏
 * @date 2021/9/4
 */
@Controller("userController")
@RequestMapping("/user")
public class request {

    //http://localhost:8080/login/user/quick
    //get方式才能访问,且参数必须含有username,password,money不能为100
    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username","password","money!=100"})
    //return的为要跳转的视图
    public String save(){
        System.out.println("Controller save running...");
        //加一个"/"则从当前webapp下找对应资源,不加"/"则找http://localhost:8080/login/user/success.jsp
//        return "/success.jsp";
        //加redirect:为重定向(默认为forward)
//        return "redirect:/success.jsp";

//        在spring-mvc.xml文件配置内部资源视图解析器后可自动拼接前后缀
        return "success2";
    }

    /*
     * Model:模型 用于封装数据
     * View:视图  用于展示数据
     */
    @RequestMapping("/quick2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据(相当于setAttribute)
        modelAndView.addObject("username","lisa2");
        //设置视图名称
        modelAndView.setViewName("success2");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","lisa3");
        modelAndView.setViewName("success2");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save4(Model model){
        model.addAttribute("username","lisa4");
        return "success2";
    }
    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","lisa5");
        return "success2";
    }

}
