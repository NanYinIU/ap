package com.nanyin.ap.model.Ex;

import com.nanyin.ap.model.Parts;
import com.nanyin.ap.model.Purchaseorder;
import com.nanyin.ap.model.Supplier;
import com.nanyin.ap.model.Users;


/**
 * @author nanyin
 * @time 下午6:07
 * @name PurchaseOrderEx
 * @description
 */
public class PurchaseOrderEx {
    private Purchaseorder purchaseorder;
    private Users users;
    private Parts parts;
    private Supplier supplier;

    public Purchaseorder getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(Purchaseorder purchaseorder) {
        this.purchaseorder = purchaseorder;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
