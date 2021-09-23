package login.web;

import login.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserController_xml {
    public static void main(String[] args) {
//        FileSystemXmlApplicationContext app = new FileSystemXmlApplicationContext("B:\\IDEAproject\\Spring2\\src\\main\\resources\\applicationContext.xml");
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
