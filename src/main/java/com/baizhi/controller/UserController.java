package com.baizhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username,String password){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username,password));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login error";
        }
        return "login success";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "logout error";
        }
        return "logout success";
    }
}
