package com.bmw.elitedrive.module.client.service;

import com.bmw.elitedrive.common.exception.EntityExistsException;
import com.bmw.elitedrive.common.exception.EntityNotFoundException;
import com.bmw.elitedrive.module.client.dao.ClientRepository;
import com.bmw.elitedrive.module.client.dao.ClientService;
import com.bmw.elitedrive.module.client.model.Client;
import com.bmw.elitedrive.module.client.model.GetClientRequest;
import com.bmw.elitedrive.module.client.model.GetClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.bmw.elitedrive.module.client.dao.Mapper.*;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepo;

    @Override
    @Transactional
    public GetClientResponse addClient(GetClientRequest request) {
        clientRepo.findClientByIdNumber(request.getIdNumber())
                .ifPresent(c -> {
                    throw new EntityExistsException("A client already exists in our records with the id number: " + request.getIdNumber());
                });

        Client client = mapToClient(request);
        return mapToGetClientResponse(clientRepo.saveAndFlush(client));
    }

    @Override
    @Transactional
    public GetClientResponse deleteClient(Long clientId) {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client with id not found: " + clientId));

        clientRepo.delete(client);
        return mapToGetClientResponse(client);
    }
}
