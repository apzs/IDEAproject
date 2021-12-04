package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author 无名氏
 * @date 2021/9/5
 */
@Controller
@RequestMapping("/user")
public class Servlet {

//    http://localhost:8080/login/user/test
    @RequestMapping("/test")
    @ResponseBody
    public void test(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/test2")
    @ResponseBody
    public void test2(@RequestHeader(value = "User-Agent",required = false) String user_agent){
        //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36
        System.out.println(user_agent);
    }

    @RequestMapping("/test3")
    @ResponseBody
    public void test3(@CookieValue(value = "JSESSIONID",required = false) String jSessionId){
        //8CF94F29E747470DE2A70BAE9018CF8C
        System.out.println(jSessionId);
    }

    //http://localhost:8080/login/fileUpload.jsp
    //在pom.xml文件中导入fileUpload和io坐标,在spring-mvc.xml中配置文件上传解析器
    @RequestMapping("/test4")
    @ResponseBody
    public void test4(String name, MultipartFile file) throws IOException {
        System.out.println(name);
        //获得文件名称
        String filename = file.getOriginalFilename();
        file.transferTo(new File("A:\\"+filename));
    }

    //http://localhost:8080/login/fileUpload2.jsp
    //http://localhost:8080/login/fileUpload3.jsp
    //多文件上传
    @RequestMapping("/test5")
    @ResponseBody
    public void test5(String name, MultipartFile[] file) throws IOException {
        System.out.println(name);
        //获得文件名称
        for (MultipartFile multipartFile : file) {
            String filename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("A:\\"+filename));
        }
    }

}
