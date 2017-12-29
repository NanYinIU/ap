package com.nanyin.ap.service;


import com.nanyin.ap.model.Client;

import java.util.List;

public interface ClientService {

    Client findClientById(int id);

    Client findClientByClientName(String name);

    List<Client> findAllClientMes();
}