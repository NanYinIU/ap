package com.nanyin.ap.service;

import com.nanyin.ap.model.Ex.SalesOrderEx;

import java.util.List;
import java.util.Map;

/**
 * @author nanyin
 * @time 下午 12:16
 * @name SalesorderService
 * @description
 */
public interface SalesorderService {

    Map<String,Object> salesOrdersLimit(int pageNum,String timePick);

    int DeleteSalesOrdersById(int id);

    SalesOrderEx findAllMesOfSales(int id);

    int updateSaleOrders(int id, String sId, String sNumber, String sPay,String sUserName, String sClientName, String sketch);

    int insertSaleOrders(String sId, String sNumber, String sPay, String sClientName, String sketch,String userName);

}
