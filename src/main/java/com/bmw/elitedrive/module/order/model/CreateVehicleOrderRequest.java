package com.bmw.elitedrive.module.order.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
@Data
@Builder
public class CreateVehicleOrderRequest {
    private Long clientId;
    private Long vehicleId;
    private Set<Long> extraIds;
}
