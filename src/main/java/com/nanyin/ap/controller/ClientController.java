package com.nanyin.ap.controller;

import com.google.common.collect.Maps;
import com.nanyin.ap.model.Client;
import com.nanyin.ap.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nanyin
 * @time 下午3:02
 * @name ClientController
 * @description
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    /**
     * 查询client状态的 json
     * @return
     */
    @RequestMapping("/clientData")
    public @ResponseBody Map<String,Object> clientData(){
        Map<String,Map<String,Object>> map = new HashMap<>();
        Map<String,Object> innerMap = Maps.newHashMap();
        List<Client> clientList = clientService.findAllClientMes();
        innerMap.put("list",clientList);
        map.put("data",innerMap);
        return innerMap;
    }
}
