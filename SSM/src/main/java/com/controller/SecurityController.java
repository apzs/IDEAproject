package com.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 无名氏
 * @date 2021/11/21
 * @Description: TODO
 */
@RestController
@RequestMapping("/hello")
public class SecurityController {

    /**
     * @PreAuthorize: 注解表示用户必须拥有add权限才能调用当前方法
     */

    @PreAuthorize("hasAuthority('add')")
    @RequestMapping("/add")
    public void add(){
        System.out.println("add...");
    }
}
