package com.nanyin.ap.model;

/**
 * 汽车配件信息
 * 
 * @author nanyin
 * 
 * @date 2017-12-25
 */
public class Parts {
    /**
     * 配件主键
     */
    private Integer id;

    /**
     * 一级分类
     */
    private String classify;

    /**
     * 二级分类
     */
    private String secclsssfy;

    /**
     * 商品编号
     */
    private String partnumber;

    /**
     * 商品名称
     */
    private String partname;

    /**
     * 单位（计量）
     */
    private String unit;

    /**
     * 车型
     */
    private Integer cartype;

    /**
     * 产地
     */
    private String originalplace;

    /**
     * 原价
     */
    private Float originalprice;

    /**
     * 库存
     */
    private Integer repertory;

    /**
     * 备注
     */
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getSecclsssfy() {
        return secclsssfy;
    }

    public void setSecclsssfy(String secclsssfy) {
        this.secclsssfy = secclsssfy == null ? null : secclsssfy.trim();
    }

    public String getPartnumber() {
        return partnumber;
    }

    public void setPartnumber(String partnumber) {
        this.partnumber = partnumber == null ? null : partnumber.trim();
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname == null ? null : partname.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getCartype() {
        return cartype;
    }

    public void setCartype(Integer cartype) {
        this.cartype = cartype;
    }

    public String getOriginalplace() {
        return originalplace;
    }

    public void setOriginalplace(String originalplace) {
        this.originalplace = originalplace == null ? null : originalplace.trim();
    }

    public Float getOriginalprice() {
        return originalprice;
    }

    public void setOriginalprice(Float originalprice) {
        this.originalprice = originalprice;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}