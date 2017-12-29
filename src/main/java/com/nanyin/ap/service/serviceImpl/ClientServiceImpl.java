package com.nanyin.ap.service.serviceImpl;

import com.nanyin.ap.mapper.ClientMapper;
import com.nanyin.ap.model.Client;
import com.nanyin.ap.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
