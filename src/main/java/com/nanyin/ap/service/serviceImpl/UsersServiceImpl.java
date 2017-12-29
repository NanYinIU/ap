package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.UsersMapper;
import com.nanyin.ap.model.Users;
import com.nanyin.ap.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

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

    @Override
    public Users findUserByName(String name) {
        return usersMapper.findUserByName(name);
    }

    @Override
    public Users findUserByUserId(int id) {
        return usersMapper.findUserByUserId(id);
    }


}
