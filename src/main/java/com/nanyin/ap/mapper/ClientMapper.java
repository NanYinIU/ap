package com.nanyin.ap.mapper;

import com.nanyin.ap.model.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClientMapper {
    /**
     * 根据id查询客户信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM auto_parts.client WHERE id=#{id}")
    Client findClientByClientId(int id);

    @Select("SELECT * FROM auto_parts.client WHERE clientName=#{name}")
    Client findClientByClientName(String name);

    @Select("SELECT * FROM auto_parts.client")
    List<Client> findAllClientMes();
}