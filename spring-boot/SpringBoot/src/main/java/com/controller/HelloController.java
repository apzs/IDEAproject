package com.controller;

import com.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 无名氏
 * @date 2021/9/20
 */
@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${person.name}")
    private String personName;

    @Value("${address[0]}")
    private String address1;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    @Autowired
    private Environment evn;

    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(name);
        System.out.println(personName);
        System.out.println(address1);
        System.out.println(msg1);
        System.out.println(msg2);
        System.out.println("--------------------------");
        System.out.println(evn.getProperty("person.name"));
        System.out.println(evn.getProperty("address[1]"));
        System.out.println("--------------------------");
        System.out.println(person);
        return  "hello SpringBoot !";
    }
}
