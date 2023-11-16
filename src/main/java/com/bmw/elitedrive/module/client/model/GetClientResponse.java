package com.bmw.elitedrive.module.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetClientResponse {
    private Long clientId;
    private String name;
    private String surname;
}
