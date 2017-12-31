package com.nanyin.ap.model.vo;

/**
 * @author nanyin
 * @time 下午6:45
 * @name UserVo
 * @description
 */
public class UserVo {
    private Integer id;

    /**
     * 工作区域 如：分店1
     */
    private String workplace;

    /**
     * 电话
     */
    private String phonenumber;

    /**
     * 其他说明
     */
    private String describe;

    /**
     * 操作员的用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
