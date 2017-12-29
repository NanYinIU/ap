package com.nanyin.ap.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 销售单（出货单）
 * 
 * @author nanyin
 * 
 * @date 2017-12-25
 */
public class Salesorder {
    private Integer id;

    /**
     * 商品配件外键
     */
    private Integer partid;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date saletime;

    /**
     * 销售数量
     */
    private Integer salenumber;

    /**
     * 业务员Id外键
     */
    private Integer userid;

    /**
     * 付款方式
     */
    private String payway;

    /**
     * 客户信息外键
     */
    private Integer clientid;

    /**
     * 其他信息
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

    public Date getSaletime() {
        return saletime;
    }

    public void setSaletime(Date saletime) {
        this.saletime = saletime;
    }

    public Integer getSalenumber() {
        return salenumber;
    }

    public void setSalenumber(Integer salenumber) {
        this.salenumber = salenumber;
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

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}