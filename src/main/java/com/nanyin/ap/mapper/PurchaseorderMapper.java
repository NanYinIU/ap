package com.nanyin.ap.mapper;



import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

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

}