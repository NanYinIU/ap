package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.PurchaseorderMapper;
import com.nanyin.ap.model.Supplier;
import com.nanyin.ap.model.Users;
import com.nanyin.ap.service.PurchaseOrderService;
import com.nanyin.ap.service.SupplierService;
import com.nanyin.ap.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author nanyin
 * @time 下午4:43
 * @name PurchaseOrderServiceImpl
 * @description
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    UsersService usersService;
    @Autowired
    PurchaseorderMapper purchaseorderMapper;
    @Autowired
    SupplierService supplierService;
    /**
     * 创建新的出货单
     * @param nId
     * @param nNumber
     * @param nPay
     * @param nSupplierName
     * @param nSketch
     * @return
     */
    @Override
    public int createPurchaseOrder(String nId, String nNumber, String nPay, String nSupplierName, String nSketch, String userName) {

        int partId = Integer.parseInt(nId);
        int number = Integer.parseInt(nNumber);

        Supplier supplier = supplierService.findSupplierByName(nSupplierName);
        Users users = usersService.findUserByName(userName);
        int flag = 0;
        try{
            flag =  purchaseorderMapper.insertPurchaseOrder(partId,new Timestamp(System.currentTimeMillis()),number,users.getId(),nPay,supplier.getId(),nSketch);
        }catch (Exception e){
            flag=0;
        }
        return flag;
    }

}
