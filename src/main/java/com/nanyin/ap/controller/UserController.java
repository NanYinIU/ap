package com.nanyin.ap.controller;

import com.google.common.collect.Maps;
import com.nanyin.ap.model.vo.UserVo;
import com.nanyin.ap.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author nanyin
 * @time 下午4:38
 * @name UserController
 * @description
 */
@Controller
public class UserController {
    @Autowired
    UsersService usersService;
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

    @RequestMapping("/user/userTableData/{pageNum}")
    public @ResponseBody Map<String,Object> userTableData(@PathVariable("pageNum") int pageNum){
        Map<String,Object> map = Maps.newHashMap();
        List<UserVo> list = usersService.userTable(pageNum);
        map.put("code",0);
        map.put("mes","");
        map.put("count",list.size());
        map.put("data",list);
        map.put("pageNum",pageNum);
        return map;
    }
    @RequestMapping("/user/userPage")
    public ModelAndView userPage(String url){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("url",url);
        return modelAndView;
    }

    @RequestMapping("/user/updateUserRole/{userId}")
    public int updateUserRole(@RequestParam("role") String roleId,@PathVariable("userId") int userId){
        int role = Integer.parseInt(roleId);
        return usersService.updateUsersRole(role,userId);
    }

}
