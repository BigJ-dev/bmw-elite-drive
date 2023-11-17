package com.bmw.elitedrive.module.order.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class GetVehicleOrderResponse {
    private String clientName;
    private Instant orderDate;
    private Instant estimatedDeliveryDate;
    private String status;
    private String model;
    private int year;
    private String manufacturer;
    private String standardFeatures;
    private BigDecimal vehicleBasePrice;
    private BigDecimal totalPrice;
    private Long orderId;
    private Long clientId;
    private Long vehicleId;
    OrderExtras orderExtras;
}
