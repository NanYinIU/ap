package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.RoleMapper;
import com.nanyin.ap.model.Role;
import com.nanyin.ap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


/**
 * @author nanyin
 * @time 下午4:35
 * @name RoleServiceImpl
 * @description
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Set<String> findRoleByName(String username) {
        return roleMapper.findRolesByUsername(username);
    }

    @Override
    public List<Role> userRole() {
        return roleMapper.findRolesName();
    }
}
