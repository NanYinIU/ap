package com.nanyin.ap.mapper;

import com.nanyin.ap.model.Client;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
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

    @Select({
            "<script>",
            "SELECT * FROM auto_parts.client",
            "<if test=\"search!=null and search!=''\">",
            "AND clientName LIKE concat(concat('%',#{search}),'%') ",
            "</if>",
            "LIMIT #{page},#{limit}",
            "</script>"
    })
    List<Client> findClientSearch(@Param("page") int page,
                                  @Param("limit") int limit,
                                  @Param("search") String search);

    @Delete("DELETE FROM auto_parts.client WHERE id=#{id}")
    int deleteClient(int id);

    @Insert("INSERT INTO auto_parts.client" +
            "(typeName,clientName,address,manager," +
            "region,currentTime,phoneNumber,bank,cardNumber,`describe`) " +
            "VALUES(#{typeName},#{clientName},#{address},#{manager},#{region}," +
            "#{currentTime},#{phoneNumber},#{bank},#{carNumber},#{describe})")
    int insertClient(@Param("typeName") String typeName,
                     @Param("clientName")String clientName,
                     @Param("address")String address,
                     @Param("manager")String manager,
                     @Param("region")String region,
                     @Param("currentTime")Timestamp currentTime,
                     @Param("phoneNumber") int phoneNumber,
                     @Param("bank")String bank ,
                     @Param("carNumber")int carNumber,
                     @Param("describe")String describe);

    @Update("UPDATE auto_parts.client SET typeName=#{typeName}," +
            "address=#{address},manager=#{manager}," +
            "region=#{region},phoneNumber=#{phoneNumber}," +
            "bank=#{bank},cardNumber=#{cardNumber},`describe`=#{describe} WHERE id = #{id}")
    int updateClient(@Param("typeName")String typeName,
                     @Param("address")String address,
                     @Param("manager")String manager,
                     @Param("region")String region,
                     @Param("phoneNumber") int phoneNumber,
                     @Param("bank")String bank ,
                     @Param("cardNumber")int cardNumber,
                     @Param("describe")String describe,
                     @Param("id")int id);
}