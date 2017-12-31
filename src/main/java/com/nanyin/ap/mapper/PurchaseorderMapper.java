package com.nanyin.ap.mapper;



import com.nanyin.ap.model.Purchaseorder;
import com.nanyin.ap.model.Salesorder;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PurchaseorderMapper {

    /**
     * 插入进货单项
     * @param partId
     * @param purchaseTime
     * @param purchaseNumber
     * @param userId
     * @param payWay
     * @param supplierId
     * @param describe
     * @return
     */
    @Insert("INSERT INTO auto_parts.purchaseOrder" +
            "(partId,purchaseTime,purchaseNumber,userId,payWay,supplierId,`describe`)  " +
            "VALUES(#{partId},#{purchaseTime},#{purchaseNumber},#{userId},#{payWay},#{supplierId},#{describe})")
    int insertPurchaseOrder(@Param("partId") int partId,
                            @Param("purchaseTime")Timestamp purchaseTime,
                            @Param("purchaseNumber")int purchaseNumber,
                            @Param("userId") int userId,
                            @Param("payWay") String payWay,
                            @Param("supplierId") int supplierId,
                            @Param("describe")String describe);

    @Select({"<script>",
            "SELECT * FROM auto_parts.purchaseOrder  WHERE 1=1",

            "<if test=\"endTime!=null\">",
            "AND purchaseTime > #{endTime}",
            "</if>",

            "LIMIT #{page},#{limit}",
            "</script>"})
    List<Purchaseorder> findPurchaseOrders(@Param("page") int page,
                                       @Param("limit") int limit,
                                       @Param("startTime") Timestamp startTime,
                                       @Param("endTime") Timestamp endTime);

    @Delete("DELETE FROM auto_parts.purchaseOrder WHERE id=#{id}")
    int deletePurchaseOrderByOrderId(int id);

    @Select("Select * from auto_parts.purchaseOrder WHERE id = #{id}")
    Purchaseorder findPruchaseOrderById(int id);

    /**
     *
     * @param partId
     * @param purchaseNumber
     * @param userId
     * @param payWay
     * @param supplierId
     * @param describe
     * @param id
     * @return
     */
    @Update("UPDATE auto_parts.purchaseOrder " +
            "SET partId=#{partId},purchaseNumber=#{purchaseNumber},userId=#{userId},payWay=#{payWay},supplierId=#{supplierId},`describe`=#{describe} " +
            "WHERE id=#{id}")
    int updatePurchaseOrderById(@Param("partId") int partId,
                                @Param("purchaseNumber")int purchaseNumber,
                                @Param("userId")int userId,
                                @Param("payWay")String payWay,
                                @Param("supplierId")int supplierId,
                                @Param("describe")String describe,
                                @Param("id")int id);
}