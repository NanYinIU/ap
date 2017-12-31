package com.nanyin.ap.service;


import com.nanyin.ap.model.Client;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface ClientService {

    Client findClientById(int id);

    Client findClientByClientName(String name);

    List<Client> findAllClientMes();

    Map<String,Object> findClientBySearch(int pageNum, String search);

    int deleteClient(int id);

    int insertClient(String typeName,String clientName,String address,String manager,String region,String phoneNumber,String bank ,String carNumber,String describe);

    int updateClient(String typeName,String address,String manager,String region,String phoneNumber,String bank,String carNumber,String describe,int id);
}