package com.bmw.elitedrive.module.client.dao;

import com.bmw.elitedrive.module.client.model.GetClientRequest;
import com.bmw.elitedrive.module.client.model.GetClientResponse;

public interface ClientService {
    GetClientResponse addClient(GetClientRequest request);
    GetClientResponse deleteClient(Long clientId);
}
