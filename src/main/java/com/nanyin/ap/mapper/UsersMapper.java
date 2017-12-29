package com.nanyin.ap.mapper;

import com.nanyin.ap.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper {
    /**
     * 控制登录信息的查询
     * @param name
     * @return
     */
    @Select("SELECT * FROM auto_parts.users WHERE userName = #{name}")
    Users findUserByName(@Param("name") String name);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM auto_parts.users WHERE id=#{id}")
    Users findUserByUserId(int id);

//    @Select("SELECT id FROM auto_parts.users WHERE userName=#{name}")
//    Integer findUserIdByName(String name);

}