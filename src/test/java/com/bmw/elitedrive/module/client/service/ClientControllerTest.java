package com.bmw.elitedrive.module.client.service;

import com.bmw.elitedrive.common.ComponentTest;
import com.bmw.elitedrive.common.TestContainers;
import com.bmw.elitedrive.module.client.model.CreateClientRequest;
import com.bmw.elitedrive.module.client.model.GetClientResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@ComponentTest
public class ClientControllerTest extends TestContainers {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void addClientByDealer_ShouldReturnClient() {
        // Given
        CreateClientRequest request = CreateClientRequest.builder()
                .name("Tshepo")
                .surname("Segoapa")
                .idNumber("ID123456r")
                .contactInfo("john.doe@example.com")
                .address("1234 Elm Street")
                .build();

        // When
        ResponseEntity<GetClientResponse> response = restTemplate.exchange(
                "http://localhost:8080/bmw/elite-drive/v1/client",
                HttpMethod.POST,
                new HttpEntity<>(request),
                new ParameterizedTypeReference<>() {
                },
                port);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tshepo", response.getBody().getName());
        assertEquals("Segoapa", response.getBody().getSurname());
    }

}