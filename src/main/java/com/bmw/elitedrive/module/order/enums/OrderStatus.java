package com.bmw.elitedrive.module.order.enums;

import com.bmw.elitedrive.common.exception.OrderVehicleException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    PAID("Paid"),
    PROCESSING("Processing"),
    CANCELLED("Cancelled"),
    CLOSED("Closed"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private final String value;

    public static OrderStatus from(String value) {
        for (OrderStatus current : values())
            if (current.getValue()
                    .equalsIgnoreCase(value)) {
                return current;
            }
        throw new OrderVehicleException("No order status found with value '" + value + "'");
    }
}
