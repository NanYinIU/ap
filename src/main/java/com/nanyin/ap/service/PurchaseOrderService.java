package com.nanyin.ap.service;

import com.nanyin.ap.model.Ex.PurchaseOrderEx;
import com.nanyin.ap.model.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @author nanyin
 * @time 下午4:42
 * @name PurchaseOrderService
 * @description
 */
public interface PurchaseOrderService {
    int createPurchaseOrder(String nId, String nNumber, String nPay, String nSupplierName, String nSketch,String userName);

    Map<String,Object> purchaseOrdersLimit(int pageNum, String timePick);

    int deletePurchaseOrderByOrderId(int id);

    PurchaseOrderEx findPurchaseOrderMes(int id);

    int modifyPurchOrder(String sId, String sNumber, String sUserName, String sPay, String sSupplierName, String sketch,int id);
}
