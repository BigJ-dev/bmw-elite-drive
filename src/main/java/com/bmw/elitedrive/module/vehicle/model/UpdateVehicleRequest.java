package com.bmw.elitedrive.module.vehicle.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class UpdateVehicleRequest {
    private int year;
    private String model;
    private BigDecimal basePrice;
    private String manufacturer;
    private String standardFeatures;
}
