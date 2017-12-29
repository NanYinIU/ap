package com.nanyin.ap.model;

/**
 * 权限表
 * 
 * @author nanyin
 * 
 * @date 2017-12-25
 */
public class Permission {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限名称描述
     */
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}