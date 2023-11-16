package com.bmw.elitedrive.module.client.dao;

import com.bmw.elitedrive.common.util.TimeMachine;
import com.bmw.elitedrive.module.client.model.ClientJpa;
import com.bmw.elitedrive.module.client.model.CreateClientRequest;
import com.bmw.elitedrive.module.client.model.GetClientResponse;

public interface Mapper {
    static GetClientResponse mapClientJpaToResponse(ClientJpa clientJpa) {
        return GetClientResponse.builder()
                .clientId(clientJpa.getClientId())
                .name(clientJpa.getName())
                .surname(clientJpa.getSurname())
                .build();
    }

    static ClientJpa mapClientRequestToClientJpa(CreateClientRequest request) {
        return  ClientJpa.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .idNumber(request.getIdNumber())
                .contactInfo(request.getContactInfo())
                .address(request.getAddress())
                .registrationDate(TimeMachine.getNow())
                .build();
    }

}
