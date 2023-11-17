package com.bmw.elitedrive.module.order.dao;


import com.bmw.elitedrive.module.client.model.ClientJpa;
import com.bmw.elitedrive.module.extra.model.ExtraJpa;
import com.bmw.elitedrive.module.extra.model.GetExtraResponse;
import com.bmw.elitedrive.module.order.model.GetVehicleOrderResponse;
import com.bmw.elitedrive.module.order.model.OrderExtras;
import com.bmw.elitedrive.module.order.model.OrderJpa;

import java.util.List;

public interface Mapper {

    static OrderExtras mapToOrderExtras(List<GetExtraResponse>  extras) {
        return OrderExtras.builder()
                .extras(extras)
                .build();
    }
    static GetVehicleOrderResponse mapToVehicleOrderResponse(ClientJpa client, OrderJpa order, OrderExtras orderExtras) {
        return GetVehicleOrderResponse.builder()
                .orderId(order.getOrderId())
                .clientId(client.getClientId())
                .clientName(client.getName())
                .orderDate(order.getOrderDate())
                .estimatedDeliveryDate(order.getEstimatedDeliveryDate())
                .status(order.getStatus())
                .totalPrice(order.getTotalPrice())
                .orderExtras(orderExtras)
                .build();
    }
}

