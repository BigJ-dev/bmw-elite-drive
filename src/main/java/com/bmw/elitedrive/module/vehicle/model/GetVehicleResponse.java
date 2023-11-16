package com.bmw.elitedrive.module.vehicle.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Builder
@Data
public class GetVehicleResponse {
    private Long vehicleId;
    private int year;
    private String model;
    private BigDecimal basePrice;
    private String manufacturer;
    private String standardFeatures;
}
