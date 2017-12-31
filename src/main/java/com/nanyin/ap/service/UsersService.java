package com.nanyin.ap.service;

import com.nanyin.ap.model.Users;
import com.nanyin.ap.model.vo.UserVo;

import java.util.List;

/**
 * @author nanyin
 * @time
 * @description
 */
public interface UsersService {
    Users findUserByName(String name);

    Users findUserByUserId(int id);

    List<UserVo> userTable(int pageNum);

    int updateUsersRole(int roleId,int userId);

}
