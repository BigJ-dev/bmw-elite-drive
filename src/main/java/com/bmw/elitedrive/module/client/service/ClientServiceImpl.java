package com.bmw.elitedrive.module.client.service;

import com.bmw.elitedrive.common.exception.EntityExistsException;
import com.bmw.elitedrive.common.exception.EntityNotFoundException;
import com.bmw.elitedrive.module.client.dao.ClientRepository;
import com.bmw.elitedrive.module.client.dao.ClientService;
import com.bmw.elitedrive.module.client.model.ClientJpa;
import com.bmw.elitedrive.module.client.model.CreateClientRequest;
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
    public GetClientResponse addClient(CreateClientRequest request) {
        clientRepo.findClientByIdNumber(request.getIdNumber())
                .ifPresent(c -> {
                    throw new EntityExistsException("A client already exists in our records with the id number: " + request.getIdNumber());
                });

        ClientJpa clientJpa = mapClientRequestToClientJpa(request);
        return mapClientJpaToResponse(clientRepo.saveAndFlush(clientJpa));
    }

    @Override
    @Transactional
    public GetClientResponse deleteClient(Long clientId) {
        ClientJpa clientJpa = clientRepo.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client with id not found: " + clientId));

        clientRepo.delete(clientJpa);
        return mapClientJpaToResponse(clientJpa);
    }
}
