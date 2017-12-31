package com.nanyin.ap.controller;

import com.google.common.collect.Maps;
import com.nanyin.ap.model.Client;
import com.nanyin.ap.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
        Map<String,Object> innerMap = Maps.newHashMap();
        List<Client> clientList = clientService.findAllClientMes();
        innerMap.put("list",clientList);
        return innerMap;
    }

    @RequestMapping("/clientSearch/{pageNum}")
    public @ResponseBody Map<String,Object> clientSearch(@PathVariable("pageNum")int pageNum,
                                           @RequestParam(value = "search",required = false) String search){
        return clientService.findClientBySearch(pageNum,search);
    }


    @RequestMapping("/clientPage")
    public @ResponseBody ModelAndView clientPage(String url){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client");
        modelAndView.addObject("url",url);
        return modelAndView;
    }

    @RequestMapping("/deleteClient/{id}")
    public @ResponseBody int deleteClient(@PathVariable(value = "id") int id){
        return clientService.deleteClient(id);
    }

    @RequestMapping("/newClientPage")
    public String newClientPage(){
        return "newClient";
    }

    @RequestMapping("/newClient")
    public @ResponseBody int newClient(@RequestParam("type") String type,
                                       @RequestParam("clientName")String clientName,
                                       @RequestParam("address")String address,
                                       @RequestParam("manager")String manager,@RequestParam("region")String region,
                                       @RequestParam("phoneNumber")String phoneNumber,@RequestParam("bank")String bank,
                                       @RequestParam("cardNumber")String cardNumber,@RequestParam("sketch")String sketch){
        return clientService.insertClient(type,clientName,address,manager,region,phoneNumber,bank,cardNumber,sketch);
    }

    @RequestMapping("/editClient/{id}")
    public @ResponseBody ModelAndView editClient(@PathVariable(value = "id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editClient");
        Client client = clientService.findClientById(id);
        modelAndView.addObject("list",client);
        return modelAndView;
    }

    @RequestMapping("/modifyClientMes/{id}")
    public @ResponseBody int modifyClientMes(@PathVariable("id") int id,
                               @RequestParam("typename") String typename,
                               @RequestParam("address")String address,
                               @RequestParam("manager")String manager,
                               @RequestParam("region")String region,
                               @RequestParam("phonenumber")String phonenumber,
                               @RequestParam("bank")String bank,
                               @RequestParam("cardnumber")String cardnumber,
                               @RequestParam("sketch")String sketch){
        return clientService.updateClient(typename,address,manager,region,phonenumber,bank,cardnumber,sketch,id);
    }

}
