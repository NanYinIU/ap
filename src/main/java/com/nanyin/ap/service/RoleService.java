package com.nanyin.ap.service;

import java.util.Set;

/**
 * @author nanyin
 * @time 下午4:36
 * @name RoleService
 * @description
 */
public interface RoleService {

    Set<String> findRoleByName(String username);
}
