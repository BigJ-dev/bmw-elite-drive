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
    private BigDecimal totalPrice;
    private Long orderId;
    private Long clientId;
    OrderExtras orderExtras;
}
