package com.controller;

import com.domain.Accounts;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //http://localhost:8080/SSM/pages/save.jsp
    //保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Accounts accounts){
        accountService.save(accounts);
        return "保存成功";
    }

    //http://localhost:8080/SSM/account/findAll
    //查询
    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Accounts> accountList = accountService.findAll();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }

}
