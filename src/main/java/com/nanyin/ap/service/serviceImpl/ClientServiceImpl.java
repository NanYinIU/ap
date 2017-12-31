package com.nanyin.ap.service.serviceImpl;

import com.google.common.collect.Maps;
import com.nanyin.ap.mapper.ClientMapper;
import com.nanyin.ap.model.Client;
import com.nanyin.ap.service.ClientService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author nanyin
 * @time 下午12:59
 * @name ClientServiceImpl
 * @description
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientMapper clientMapper;
    @Override
    public Client findClientById(int id) {
        return clientMapper.findClientByClientId(id);
    }

    @Override
    public Client findClientByClientName(String name) {
        return clientMapper.findClientByClientName(name);
    }

    @Override
    public List<Client> findAllClientMes() {
        return clientMapper.findAllClientMes();
    }

    @Override
    public Map<String, Object> findClientBySearch(int pageNum, String search) {
        int limit = 10 ;
        List<Client> clientList = clientMapper.findClientSearch((pageNum - 1) * limit,limit,search);
        Map<String,Object> map = Maps.newHashMap();
        map.put("code",0);
        map.put("mes","");
        map.put("count",clientList.size());
        map.put("data",clientList);
        map.put("pageNum",pageNum);
        return map;
    }

    @Override
    public int deleteClient(int id) {
        int flag = 0 ;
        if(SecurityUtils.getSubject().hasRole("admin")){
            flag = clientMapper.deleteClient(id);
        }
        return flag;
    }

    @Override
    public int insertClient(String typeName, String clientName,
                            String address, String manager, String region,
                            String phoneNumber, String bank, String carNumber, String describe) {
        int phone = Integer.parseInt(phoneNumber);
        int car = Integer.parseInt(carNumber);
        return clientMapper.insertClient(typeName,clientName,address,manager,region,new Timestamp(System.currentTimeMillis()),phone,bank,car,describe);
    }

    @Override
    public int updateClient(String typeName, String address, String manager, String region, String phoneNumber, String bank, String carNumber, String describe,int id) {
        int phone = Integer.parseInt(phoneNumber);
        int car = Integer.parseInt(carNumber);
        return clientMapper.updateClient(typeName,address,manager,region,phone,bank,car,describe,id);
    }
}
