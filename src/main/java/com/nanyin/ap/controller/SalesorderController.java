package com.nanyin.ap.controller;

import com.nanyin.ap.service.RoleService;
import com.nanyin.ap.service.SalesorderService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author nanyin
 * @time 下午12:16
 * @name SalesorderController
 * @description
 */
@Controller
public class SalesorderController {
    @Autowired
    SalesorderService salesorderService;
    @Autowired
    RoleService roleService;
    /**
     * 返回销售单的数据信息
     * @param pageNum
     * @param timePicker
     * @return
     */
    @RequestMapping("/salesOrder/data/{pageNum}")
    public @ResponseBody
    Map<String,Object> saleOrderData(@PathVariable(value = "pageNum") int pageNum,
                      @RequestParam(value = "timePick",required = false) String timePicker
                                                    ) {
        System.out.println(timePicker);
        return salesorderService.salesOrdersLimit(pageNum,timePicker);
    }

    /**
     *
     * @param url
     * @return 销售订单管理页面
     */
    @RequestMapping("/salesOrder/SaleOrderPage")
    public ModelAndView returnSaleOrderPage(String url){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",url);
        modelAndView.setViewName("salesOrder");
        return modelAndView;
    }

    /**
     * 删除订单信息
     * @param id
     * @return 正常返回 1 若不正常返回 0
     */
    @RequestMapping("/salesOrder/DeleteSaleOrder/{id}")
    public @ResponseBody int DeleteSaleOrderMes( @PathVariable(value = "id") int id){
        // 这里应该设全局的角色控制 如使用hasRoles list<String>.... 这里就简单写了
        if(SecurityUtils.getSubject().hasRole("admin")){
            return 0;
        }else
        return salesorderService.DeleteSalesOrdersById(id);
    }

    /**
     * 通过订单id查看全部信息 并更改
     * @param id
     * @return
     */
    @RequestMapping("/salesOrder/ShowSaleOrderById/{id}")
    public @ResponseBody ModelAndView ShowSaleOrderById(
            @PathVariable(value = "id") int id)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editSalesOrder");
        modelAndView.addObject("list",salesorderService.findAllMesOfSales(id));
        return modelAndView;
    }

    /**
     * 测试json方法 用完就删
     * @param id
     * @return
     */
    @RequestMapping("/salesOrder/ShowSaleOrderById2/{id}")
    public @ResponseBody Map<String,Object> ShowSaleOrderById2(
            @PathVariable(value = "id") int id)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("list",salesorderService.findAllMesOfSales(id));
        return map;
    }


    @RequestMapping("/salesOrder/modifySaleOrderById/{id}")
    public @ResponseBody int modifySaleOrderById(@PathVariable(value = "id") int id,
                                                          @RequestParam(value = "sId") String sId,
                                                          @RequestParam(value = "sNumber")String sNumber,
                                                          @RequestParam(value = "sPay")String sPay,
                                                          @RequestParam(value = "sUserName")String sUserName,
                                                          @RequestParam(value = "sClientName")String sClientName,
                                                          @RequestParam(value = "sketch")String sketch)
    {
        return salesorderService.updateSaleOrders(id, sId, sNumber, sPay, sUserName, sClientName, sketch);
    }

    /**
     *
     * @return 修改订单页
     */
    @RequestMapping("/salesOrder/showSalesOrderMes")
    public String showSalesOrderMes(){
        return "editSalesOrder";
    }

    /**
     *
     * @return 返回订单页
     */
    @RequestMapping("/salesOrder/newSalesOrderPage")
    public String newSalesOrderPage(){
        return "newSalesOrder";
    }

    /**
     * 新建订单
     * @param sId
     * @param sNumber
     * @param sPay
     * @param sClientName
     * @param sketch
     * @return
     */
    @RequestMapping("/salesOrder/newSalesOrderData")
    public @ResponseBody int newSalesOrderData(@RequestParam(value = "nId") String nId,
                                               @RequestParam(value = "nNumber")String nNumber,
                                               @RequestParam(value = "nPay")String nPay,
                                               @RequestParam(value = "nClientName")String nClientName,
                                               @RequestParam(value = "cSketch")String cSketch,
                                               HttpServletRequest request){
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("user");
        System.out.println("username="+userName);
        return salesorderService.insertSaleOrders(nId,nNumber,nPay,nClientName,cSketch,userName);
    }


}
