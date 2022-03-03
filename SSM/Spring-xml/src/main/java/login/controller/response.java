package login.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import login.domain.User2;
import login.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/5
 */
@Controller
@RequestMapping("/user")
public class response {

    @RequestMapping("/save")
    public void save(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello");
    }

    @RequestMapping("/save2")
    //告知Spring-MVC框架不进行视图跳转，直接进行视图响应
    @ResponseBody
    public String save2(){
       return "Hello2";
    }

    @RequestMapping("/save3")
    @ResponseBody
    public String save3(){
        return "{\"username\":\"lisa\":\"age\":21}";
    }

    @RequestMapping("/save4")
    @ResponseBody
    public String save4() throws JsonProcessingException {
        User2 user = new User2("lisa4",22);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/save5")
    //在spring-mvc.xml配置处理器映射器后，SpringMvc自动将User对象转换成json格式的字符串
    @ResponseBody
    public User2 save5(){
        User2 user = new User2("lisa5",22);
        return user;
    }

//    http://localhost:8080/login/user/save6?username=%22lisa6%22&age=22
    @RequestMapping("/save6")
    @ResponseBody
    public void save6(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/save7")
    @ResponseBody
    public void save7(User2 user){
        System.out.println(user);
    }

//    http://localhost:8080/login/user/save8?str=%22lisa7%22&str=%22lisa8%22
    @RequestMapping("/save8")
    @ResponseBody
    public void save8(String[] str){
        System.out.println(Arrays.toString(str));
    }

//    http://localhost:8080/login/response_save9.jsp
    //在web.xml中配置全局过滤的filter,解决中文乱码问题
    @RequestMapping("/save9")
    @ResponseBody
    public void save9(VO vo){
        System.out.println(vo);
    }

//    http://localhost:8080/login/ajax.jsp
    @RequestMapping("/save10")
    @ResponseBody
    //发送ajax请求,可以指定contentType为json格式,可以使用@RequestBody直接接收集合数据而无需使用POJO进行封装
    //要访问jquery文件需要在spring-mvc.xml中开放资源的访问
    //在spring-mvc.xml中配置全局过滤的filter,解决中文乱码问题
    public void save10(@RequestBody List<User2> userList){
        System.out.println(userList);
    }

//    http://localhost:8080/login/user/save11?name=11
    @RequestMapping("/save11")
    @ResponseBody
    //将前端传来的name与username绑定
    public void save11(@RequestParam("name") String username){
        System.out.println(username);
    }

    @RequestMapping("/save12")
    @ResponseBody
    //required = false表示name参数不是必须的,defaultValue为默认值
    public void save12(@RequestParam(value = "name",required = false,defaultValue = "lisa") String username){
        System.out.println(username);
    }

//    http://localhost:8080/login/user/save13/lisa
    //Restful风格
    @RequestMapping("/save13/{name}")
    @ResponseBody
    //required = false表示name参数不是必须的,defaultValue为默认值
    public void save13(@PathVariable("name") String username){
        System.out.println(username);
    }

//    http://localhost:8080/login/user/save14?date=2021-10-29 (需要实现Converter接口并在spring-mvc.xml中自定义转换器)
//    不配置可以这样使用: http://localhost:8080/login/user/save14?date=2021/10/29
    @RequestMapping("/save14")
    @ResponseBody
    public void save14(Date date){
        System.out.println(date);
    }
}
