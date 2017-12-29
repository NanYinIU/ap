package com.nanyin.ap.model;

import java.util.Date;

/**
 * 购买单（进货）
 * 
 * @author nanyin
 * 
 * @date 2017-12-25
 */
public class Purchaseorder {
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
     * 业务员信息 外键
     */
    private Integer userid;

    /**
     * 付款方式
     */
    private String payway;

    /**
     * 供应商信息 外键
     */
    private Integer supplierid;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway == null ? null : payway.trim();
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}