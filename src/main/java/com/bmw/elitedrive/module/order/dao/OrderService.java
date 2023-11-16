package com.bmw.elitedrive.module.order.dao;

import com.bmw.elitedrive.module.order.model.CreateVehicleOrderRequest;
import com.bmw.elitedrive.module.order.model.GetVehicleOrderResponse;

public interface OrderService {
    GetVehicleOrderResponse createVehicleOrder(CreateVehicleOrderRequest request);
}
