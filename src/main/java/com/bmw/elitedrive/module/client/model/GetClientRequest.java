package com.bmw.elitedrive.module.client.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class GetClientRequest {
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
