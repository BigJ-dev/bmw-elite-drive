package com.bmw.elitedrive.module.client.dao;

import com.bmw.elitedrive.module.client.model.CreateClientRequest;
import com.bmw.elitedrive.module.client.model.GetClientResponse;

public interface ClientService {
    GetClientResponse addClient(CreateClientRequest request);
    GetClientResponse deleteClient(Long clientId);
}
