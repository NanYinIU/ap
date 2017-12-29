package com.nanyin.ap.service;

import java.util.Set;

/**
 * @author nanyin
 * @time 下午 4：37
 * @name PermissionService
 * @description
 */
public interface PermissionService {
    Set<String> findPermissionByName(String username);
}
