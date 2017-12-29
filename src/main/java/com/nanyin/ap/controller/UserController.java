package com.nanyin.ap.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author nanyin
 * @time 下午4:38
 * @name UserController
 * @description
 */
@Controller
public class UserController {

    /**
     *
     * @return 返回登录而界面
     */
    @RequestMapping("/user/login")
    public String login(){
        return "login";
    }

    /**
     * 登录操作
     * @param username
     * @param password
     * @param request
     * @param url
     * @return
     */
    @RequestMapping("/user/index")
    public String gotoIndex(String username, String password, HttpServletRequest request , @RequestParam(value = "url",required = false) String url){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        HttpSession session = request.getSession();

        try {
            subject.login(usernamePasswordToken);
            session.setAttribute("user",username);
            return "index";
            //登录成功返回主页 否则返回注册页面
        }catch (Exception r){
            return "login";
        }

    }

}
