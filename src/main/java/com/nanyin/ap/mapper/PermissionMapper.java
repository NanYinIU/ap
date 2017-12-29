package com.nanyin.ap.mapper;


import com.nanyin.ap.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface PermissionMapper {

    @Select("SELECT p.permission_name FROM auto_parts.permission p " +
            "LEFT JOIN auto_parts.usersRoleAndPermission urp ON p.id = urp.permissionId\n" +
            "LEFT JOIN auto_parts.users u ON urp.userId = u.id AND u.userName = #{name}")
    Set<String> findPermissionsByUsername(String name);
}