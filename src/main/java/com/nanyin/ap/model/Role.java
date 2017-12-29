package com.nanyin.ap.model;

/**
 * 角色表
 * 
 * @author nanyin
 * 
 * @date 2017-12-25
 */
public class Role {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色名(英文)
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}