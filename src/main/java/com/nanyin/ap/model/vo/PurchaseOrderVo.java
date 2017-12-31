package com.nanyin.ap.model.vo;

import java.util.Date;

/**
 * @author nanyin
 * @time 下午5:05
 * @name PurchaseOrderVo
 * @description
 */
public class PurchaseOrderVo {
    private Integer id;

    /**
     * 零件信息 外键
     */
    private Integer partid;

    /**
     * 进货时间
     */
    private Date purchasetime;

    /**
     * 进货数量
     */
    private Integer purchasenumber;

    /**
     * 业务员信息(姓名) 外键
     */
    private String userName;

    /**
     * 付款方式
     */
    private String payway;

    /**
     * 供应商信息 外键
     */
    private String supplierName;

    /**
     * 其他描述
     */
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartid() {
        return partid;
    }

    public void setPartid(Integer partid) {
        this.partid = partid;
    }

    public Date getPurchasetime() {
        return purchasetime;
    }

    public void setPurchasetime(Date purchasetime) {
        this.purchasetime = purchasetime;
    }

    public Integer getPurchasenumber() {
        return purchasenumber;
    }

    public void setPurchasenumber(Integer purchasenumber) {
        this.purchasenumber = purchasenumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
