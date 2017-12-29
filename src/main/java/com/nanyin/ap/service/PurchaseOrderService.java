package com.nanyin.ap.service;

import com.nanyin.ap.model.Supplier;

import java.util.List;

/**
 * @author nanyin
 * @time 下午4:42
 * @name PurchaseOrderService
 * @description
 */
public interface PurchaseOrderService {
    int createPurchaseOrder(String nId, String nNumber, String nPay, String nSupplierName, String nSketch,String userName);


}
