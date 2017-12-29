package com.nanyin.ap.mapper;

import com.nanyin.ap.model.Salesorder;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SalesorderMapper {
    /**
     *
     * @param page 当前也
     * @param limit 每页多少项
     * @param startTime 前几天的当天
     * @param endTime   前几天
     * @return
     */
    @Select({"<script>",
            "SELECT * FROM auto_parts.salesOrder  WHERE 1=1",

            "<if test=\"endTime!=null\">",
            "AND saleTime > #{endTime}",
            "</if>",

            "LIMIT #{page},#{limit}",
            "</script>"})
    List<Salesorder> findSaleOrders(@Param("page") int page,
                                    @Param("limit") int limit,
                                    @Param("startTime") Timestamp startTime,
                                    @Param("endTime") Timestamp endTime);

    /**
     * 通过id删除销售单信息
     * @param id
     * @return
     */
    @Delete("DELETE FROM auto_parts.salesOrder where\n" +
            " id=#{id}")
    int DeleteSaleOrdersById(int id);

    /**
     * 通过订单id查询订单详细
     * @param id
     * @return
     */
    @Select("SELECT * FROM auto_parts.salesOrder WHERE id=#{id}")
    Salesorder findSaleOrderById(int id);

    /**
     *
     * @param id
     * @param saleNumber
     * @param partId
     * @param sketch
     * @param userId
     * @param clientId
     * @param payWay
     * @return
     */
    @Update("UPDATE auto_parts.salesOrder " +
            "SET partId=#{partId} ,saleNumber=#{saleNumber},`describe`=#{describe},userId=#{userId},clientId=#{clientId} ,payWay=#{payWay}"+
            "WHERE id=#{id}")
    int updateSaleOrderById(@Param("id") int id,
                            @Param("saleNumber")int saleNumber,
                            @Param("partId") int partId,
                            @Param("describe") String sketch,
                            @Param("userId") int userId,
                            @Param("clientId") int clientId,
                            @Param("payWay") String payWay);

    /**
     * 插入新的销售单
     * @param saleNumber
     * @param partId
     * @param sketch
     * @param userId
     * @param clientId
     * @param payWay
     * @param saleTime
     * @return
     */
    @Insert("INSERT INTO auto_parts.salesOrder(partId,saleTime,saleNumber,userId,payWay,clientId,`describe`) " +
            "VALUES(#{partId},#{saleTime},#{saleNumber},#{userId},#{payWay},#{clientId},#{describe})")
    int insertSaleOrder(@Param("saleNumber")int saleNumber,
                        @Param("partId") int partId,
                        @Param("describe") String sketch,
                        @Param("userId") int userId,
                        @Param("clientId") int clientId,
                        @Param("payWay") String payWay,
                        @Param("saleTime") Timestamp saleTime);


}