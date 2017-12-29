package com.nanyin.ap.model.Ex;

import com.nanyin.ap.model.Client;
import com.nanyin.ap.model.Parts;
import com.nanyin.ap.model.Salesorder;
import com.nanyin.ap.model.Users;

/**
 * 使用定义好的bean的属性的bean
 *
 * @author nanyin
 * @time 下午3:17
 * @name SalesOrderEx
 * @description
 */
public class SalesOrderEx {
    /**
     * 订单信息
     */
    private Salesorder salesorder;
    /**
     * 订单中操作人员信息
     */
    private Users users;
    /**
     * 客户信息
     */
    private Client client;
    /**
     * 零件信息
     */
    private Parts parts;

    public Salesorder getSalesorder() {
        return salesorder;
    }

    public void setSalesorder(Salesorder salesorder) {
        this.salesorder = salesorder;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }
}
