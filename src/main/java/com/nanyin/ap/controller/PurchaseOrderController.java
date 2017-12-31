package com.nanyin.ap.controller;

import com.google.common.collect.Maps;
import com.nanyin.ap.model.Ex.PurchaseOrderEx;
import com.nanyin.ap.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
    public @ResponseBody int createPurchaseOrder(@RequestParam("nId") String nId,
                                   @RequestParam("nNumber") String nNumber,
                                   @RequestParam("nPay") String nPay,
                                   @RequestParam("nSupplierName") String nSupplierName,
                                   @RequestParam("nSketch") String nSketch, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("user");
        System.out.println("user="+userName);
        return purchaseOrderService.createPurchaseOrder(nId,nNumber,nPay,nSupplierName,nSketch,userName);
    }

    /**
     * 进货单列表
     * @param pageNum
     * @param timePicker
     * @return
     */
    @RequestMapping("/PO/purchaseOrderData/{pageNum}")
    public @ResponseBody Map<String,Object> purchaseOrderData(@PathVariable(value = "pageNum") int pageNum,
                                         @RequestParam(value = "timePick",required = false) String timePicker){
        return purchaseOrderService.purchaseOrdersLimit(pageNum,timePicker);
    }

    /**
     *
     * @return 进货单页面
     */
    @RequestMapping("/PO/purchaseOrder")
    public @ResponseBody ModelAndView purchaseOrderPage(@RequestParam(value = "url",required = false) String url){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("purchaseOrder");
        modelAndView.addObject("url",url);
        return modelAndView;
    }

    /**
     * 删除订单信息
     * @param id
     * @return
     */
    @RequestMapping("/PO/deletePurchaseOrder/{id}")
    public  @ResponseBody int deletePurchaseOrderByOrderId(@PathVariable("id") int id){

        return purchaseOrderService.deletePurchaseOrderByOrderId(id);
    }

    @RequestMapping("/PO/preEditPurchaseOrder/{id}")
    public @ResponseBody ModelAndView preEditPurchaseOrder(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPurchaseOrder");
        Map<String,Object> map = Maps.newHashMap();
        PurchaseOrderEx purchaseOrderEx = purchaseOrderService.findPurchaseOrderMes(id);
        map.put("list",purchaseOrderEx);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping("/PO/modifyPurchaseOrderData/{id}")
    public @ResponseBody int modifyPurchaseOrderData(@PathVariable(value = "id") int id,@RequestParam String sId,
                                       @RequestParam String sNumber,
                                       @RequestParam String sUserName,
                                       @RequestParam String sPay,
                                       @RequestParam String sSupplierName,
                                       @RequestParam String sketch){
        return purchaseOrderService.modifyPurchOrder( sId, sNumber, sUserName, sPay, sSupplierName, sketch,id);
    }
}
