package com.nanyin.ap.service;

import com.nanyin.ap.model.Users;

/**
 * @author nanyin
 * @time
 * @description
 */
public interface UsersService {
    Users findUserByName(String name);

    Users findUserByUserId(int id);

}
