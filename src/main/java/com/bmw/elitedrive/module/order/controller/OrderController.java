package com.bmw.elitedrive.module.order.controller;

import com.bmw.elitedrive.module.order.dao.OrderService;
import com.bmw.elitedrive.module.order.model.CreateVehicleOrderRequest;
import com.bmw.elitedrive.module.order.model.GetVehicleOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class OrderController {
    private final OrderService orderService;
    @PostMapping(value = "/vehicle-order")
    public ResponseEntity<GetVehicleOrderResponse> createVehicleOrder(@RequestBody CreateVehicleOrderRequest request) {
        return ResponseEntity.ok().body(orderService.createVehicleOrder(request));
    }
}
