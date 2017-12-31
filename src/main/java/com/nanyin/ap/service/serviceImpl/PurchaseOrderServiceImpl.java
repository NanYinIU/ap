package com.nanyin.ap.service.serviceImpl;

import com.google.common.collect.Lists;
import com.nanyin.ap.mapper.PurchaseorderMapper;
import com.nanyin.ap.model.*;
import com.nanyin.ap.model.Ex.PurchaseOrderEx;
import com.nanyin.ap.model.vo.PurchaseOrderVo;
import com.nanyin.ap.model.vo.SalesOrderVo;
import com.nanyin.ap.service.PartsService;
import com.nanyin.ap.service.PurchaseOrderService;
import com.nanyin.ap.service.SupplierService;
import com.nanyin.ap.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    PartsService partsService;
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

        int supplierId = Integer.parseInt(nSupplierName);
        Users users = usersService.findUserByName(userName);
        int flag = 0;
        try{

            flag =  purchaseorderMapper
                    .insertPurchaseOrder(partId,
                            new Timestamp(System.currentTimeMillis()),
                            number,users.getId(),nPay,supplierId,nSketch);
        }catch (Exception e){
            flag=0;
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * @param pageNum
     * @param interval
     * @return
     */

    @Override
    public Map<String, Object> purchaseOrdersLimit(int pageNum, String interval) {
        int limit = 10 ;
        int inter = 0;

        Map<String,Object> map = new HashMap<>();
        List<Purchaseorder> list = new LinkedList<>();

        if(interval != null && !"".equals(interval)) {
            inter = Integer.parseInt(interval);
            //获得当前时间
            Timestamp now = new Timestamp(System.currentTimeMillis());
            //转换成data类型进项时间的加减
            Date nowDate = new Date();
            try {
                nowDate = now;
            } catch (Exception e) {
                e.printStackTrace();
            }
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(nowDate);
            calendar.add(calendar.DATE, -inter);
            Date afterAdd = calendar.getTime();
            // 转化为timestamps类型
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String afterAddString = simpleDateFormat.format(afterAdd);
            Timestamp end = Timestamp.valueOf(afterAddString);
            // 几天前的时间 end
            list = purchaseorderMapper.findPurchaseOrders((pageNum - 1) * limit,limit,now,end);
        } else {
            list = purchaseorderMapper.findPurchaseOrders((pageNum - 1) * limit,limit,null,null);
        }
        // 在这里进行格式转化
        List<PurchaseOrderVo> newList = setValue(list);

        int count = newList.size();
        map.put("code",0);
        map.put("mes","");
        map.put("count",count);
        map.put("data",newList);
        map.put("pageNum",pageNum);
        return map;
    }

    @Override
    public int deletePurchaseOrderByOrderId(int id) {
        return purchaseorderMapper.deletePurchaseOrderByOrderId(id);
    }

    @Override
    public PurchaseOrderEx findPurchaseOrderMes(int id) {
        Users users = usersService.findUserByUserId(id);
        Supplier supplier = supplierService.findSupplierById(id);
        Purchaseorder purchaseorder = purchaseorderMapper.findPruchaseOrderById(id);
        Parts parts = partsService.findPartsById(id);
        PurchaseOrderEx purchaseOrderEx = new PurchaseOrderEx();
        purchaseOrderEx.setParts(parts);
        purchaseOrderEx.setPurchaseorder(purchaseorder);
        purchaseOrderEx.setSupplier(supplier);
        purchaseOrderEx.setUsers(users);
        return purchaseOrderEx;
    }

    /**
     * 修改
     * @param sId
     * @param sNumber
     * @param sUserName
     * @param sPay
     * @param sSupplierName
     * @param sketch
     * @param id
     * @return
     */
    @Override
    public int modifyPurchOrder(String sId, String sNumber,
                                String sUserName, String sPay,
                                String sSupplierName, String sketch,int id) {
        int partId = Integer.parseInt(sId);
        int number = Integer.parseInt(sNumber);
        Users users = usersService.findUserByName(sUserName);
        Supplier supplier = supplierService.findSupplierByName(sSupplierName);
        return purchaseorderMapper.updatePurchaseOrderById(partId,number,users.getId(),sPay,supplier.getId(),sketch,id);
    }

    /**
     * 编辑订单的时候的显示信息
     * @param list
     * @return
     */
    private List<PurchaseOrderVo> setValue(List<Purchaseorder> list) {
        List<PurchaseOrderVo> purchaseOrderVoList = Lists.newLinkedList();

        for (Purchaseorder p:list
             ) {
            PurchaseOrderVo purchaseOrderVo = new PurchaseOrderVo();
            purchaseOrderVo.setId(p.getId());
            purchaseOrderVo.setPartid(p.getPartid());
            purchaseOrderVo.setDescribe(p.getDescribe());
            purchaseOrderVo.setPayway(p.getPayway());
            purchaseOrderVo.setPurchasenumber(p.getPurchasenumber());
            purchaseOrderVo.setPurchasetime(p.getPurchasetime());
            purchaseOrderVo.setUserName(usersService.findUserByUserId(p.getUserid()).getUsername());
            purchaseOrderVo.setSupplierName(supplierService.findSupplierById(p.getSupplierid()).getSuppliername());

            purchaseOrderVoList.add(purchaseOrderVo);
        }
        return purchaseOrderVoList;

    }

}
