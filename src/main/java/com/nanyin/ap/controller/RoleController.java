package com.nanyin.ap.controller;

import com.google.common.collect.Maps;
import com.nanyin.ap.model.Role;
import com.nanyin.ap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author nanyin
 * @time 下午4:39
 * @name RoleController
 * @description
 */
@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/role/roleList")
    public @ResponseBody Map<String,Object> roleList(){
        Map<String,Object> map = Maps.newHashMap();
        List<Role> list = roleService.userRole();
        map.put("list",list);
        return map;
    }

    /**
     * 更改用户角色页面
     * @return
     */
    @RequestMapping("/role/changeRole")
    public String changeRole(){
        return "newUserRole";
    }

}
