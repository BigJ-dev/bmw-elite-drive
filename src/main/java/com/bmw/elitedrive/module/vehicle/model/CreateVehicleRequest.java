package com.bmw.elitedrive.module.vehicle.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
@Builder
public class CreateVehicleRequest {
    @NotNull
    private String model;
    @NotNull
    private int year;
    @NotNull
    private BigDecimal basePrice;
    @NotNull
    private String manufacturer;
    @NotNull
    private String standardFeatures;
}
