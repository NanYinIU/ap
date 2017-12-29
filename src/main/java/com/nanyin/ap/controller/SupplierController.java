package com.nanyin.ap.controller;

import com.google.common.collect.Maps;
import com.nanyin.ap.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author nanyin
 * @time 下午5:04
 * @name SupplierController
 * @description
 */
@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @RequestMapping("/supplier/allSupplierData")
    public @ResponseBody Map<String,List> allSupplierData(){
        Map<String,List> map = Maps.newHashMap();
        map.put("list",supplierService.findAllSupplier());
        return map;
    }
}
