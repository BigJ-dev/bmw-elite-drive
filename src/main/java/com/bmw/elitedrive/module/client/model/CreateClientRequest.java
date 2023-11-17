package com.bmw.elitedrive.module.client.model;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateClientRequest {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String idNumber;
    @NotNull
    private String contactInfo;
    @NotNull
    private String address;
}
