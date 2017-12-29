package com.nanyin.ap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nanyin
 * @time 上午9:54
 * @name ErrorController
 * @description
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String error404(){
        return "errorPage/404";
    }
    @RequestMapping("/400")
    public String error400(){
        return "errorPage/400";
    }
    @RequestMapping("/500")
    public String error500(){
        return "errorPage/404";
    }
    @RequestMapping("/unAuthorized")
    public String unAuthorized(){
        return "errorPage/unAuthorized";
    }
}
