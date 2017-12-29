package com.nanyin.ap.controller;

import com.nanyin.ap.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author nanyin
 * @time 下午4:35
 * @name PurchaseOrderController
 * @description
 */
@Controller
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    /**
     * 新建进货单页面
     * @return
     */
    @RequestMapping("/PO/newPage")
    public String newPurchaseOrderPage(){
        return "newPurchaseOrder";
    }

    /**
     * 插入属性
     * @param nId
     * @param nNumber
     * @param nPay
     * @param nSupplierName
     * @param nSketch
     * @param request
     * @return
     */
    @RequestMapping("/PO/newOrder")
    public int createPurchaseOrder(@RequestParam("nId") String nId,
                                   @RequestParam("nNumber") String nNumber,
                                   @RequestParam("nPay") String nPay,
                                   @RequestParam("nSupplierName") String nSupplierName,
                                   @RequestParam("nSketch") String nSketch, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("user");
        return purchaseOrderService.createPurchaseOrder(nId,nNumber,nPay,nSupplierName,nSketch,userName);
    }
}
