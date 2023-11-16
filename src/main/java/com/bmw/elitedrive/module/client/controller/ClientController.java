package com.bmw.elitedrive.module.client.controller;

import com.bmw.elitedrive.module.client.dao.ClientService;
import com.bmw.elitedrive.module.client.model.GetClientRequest;
import com.bmw.elitedrive.module.client.model.GetClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ClientController {

    private final ClientService clientService;

    @PostMapping(value = "/client")
    public ResponseEntity<GetClientResponse> createClient(@RequestBody GetClientRequest request) {
        return ResponseEntity.ok().body(clientService.addClient(request));
    }


    @DeleteMapping(value = "/client-delete/{clientId}")
    public ResponseEntity<GetClientResponse> deleteClient(@PathVariable("clientId") Long clientId) {
        return ResponseEntity.ok().body(clientService.deleteClient(clientId));
    }
}
