package com.controller;

import com.domain.Role;
import com.domain.User;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/12
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    private ModelAndView list(ModelAndView modelAndView) {
        List<User> userList = userService.list();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("saveUI")
    private ModelAndView saveUI(ModelAndView modelAndView) {
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    private String save(User user, Long[] roleIds) {
//        把用户存进sys_user表，把用户选择的职位存进sys_user_role表
        userService.save(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    private String del(@PathVariable("userId") Long userId) {
        userService.del(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    private String login(User user1,HttpSession session){
        User user = userService.login(user1);
        if (user!=null){
            //登录成功，将user存储到session中
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
