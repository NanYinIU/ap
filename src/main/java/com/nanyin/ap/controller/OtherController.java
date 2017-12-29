package com.nanyin.ap.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanyin
 * @time 上午11:23
 * @name OtherController
 * @description
 */
@Controller
public class OtherController {

    @RequestMapping("/other/menu")
    public String returnMeau(){
        return "menu";
    }

    @RequestMapping("/verify/hasAdminRole")
    public @ResponseBody int hasAdminRole(){
        int flag = 0;
        if(SecurityUtils.getSubject().hasRole("admin")){
            flag = 1;
        }
        return flag;
    }




}
