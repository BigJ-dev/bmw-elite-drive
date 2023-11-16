package com.bmw.elitedrive.module.client.dao;

import com.bmw.elitedrive.common.util.TimeMachine;
import com.bmw.elitedrive.module.client.model.Client;
import com.bmw.elitedrive.module.client.model.CreateClientRequest;
import com.bmw.elitedrive.module.client.model.GetClientResponse;

public interface Mapper {
    static GetClientResponse mapToGetClientResponse(Client client) {
        return GetClientResponse.builder()
                .clientId(client.getClientId())
                .name(client.getName())
                .surname(client.getSurname())
                .build();
    }

    static Client mapToClient(CreateClientRequest request) {
        return  Client.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .idNumber(request.getIdNumber())
                .contactInfo(request.getContactInfo())
                .address(request.getAddress())
                .registrationDate(TimeMachine.getNow())
                .build();
    }

}
