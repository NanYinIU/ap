package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.PermissionMapper;
import com.nanyin.ap.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author nanyin
 * @time 下午4:38
 * @name PermissionServiceImpl
 * @description
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public Set<String> findPermissionByName(String username) {
        return permissionMapper.findPermissionsByUsername(username);
    }
}
