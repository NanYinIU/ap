package com.nanyin.ap.service.serviceImpl;

import com.google.common.collect.Lists;
import com.nanyin.ap.mapper.UsersMapper;
import com.nanyin.ap.model.Users;
import com.nanyin.ap.model.vo.UserVo;
import com.nanyin.ap.service.RoleService;
import com.nanyin.ap.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author nanyin
 * @time 下午4:35
 * @name UsersServiceImpl
 * @description
 */
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    RoleService roleService;

    @Override
    public Users findUserByName(String name) {
        return usersMapper.findUserByName(name);
    }

    @Override
    public Users findUserByUserId(int id) {
        return usersMapper.findUserByUserId(id);
    }

    @Override
    public List<UserVo> userTable(int pageNum) {
        int limit = 10 ;
        List<UserVo> list = Lists.newLinkedList();
        List<Users> users = usersMapper.findUsers((pageNum - 1) * limit,limit);
        for (Users u: users
             ) {
            UserVo userVo = new UserVo();
            String userName = u.getUsername();
            Set<String> roleSet = roleService.findRoleByName(userName);
            for (String s: roleSet
                 ) {
                userVo.setRoleName(s);
            }
            userVo.setDescribe(u.getDescribe());
            userVo.setId(u.getId());
            userVo.setPassword(u.getPassword());
            userVo.setPhonenumber(u.getPhonenumber());
            userVo.setUsername(u.getUsername());
            userVo.setWorkplace(u.getWorkplace());
            list.add(userVo);
        }
        return list;
    }

    @Override
    public int updateUsersRole(int roleId, int userId) {
        int flag = 0;
        if(SecurityUtils.getSubject().hasRole("admin")){
            usersMapper.updateUsersRole(roleId,userId);
        }
        return flag;
    }


}
