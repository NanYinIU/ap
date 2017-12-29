package com.nanyin.ap.mapper;


import com.nanyin.ap.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface RoleMapper {

    @Select("SELECT r.role_name FROM auto_parts.`role` r " +
            "LEFT JOIN auto_parts.usersRoleAndPermission urp ON r.id = urp.roleId\n" +
            "LEFT JOIN auto_parts.users u ON urp.userId = u.id AND u.userName = #{name}")
    Set<String> findRolesByUsername(String name);
}