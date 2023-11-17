package com.bmw.elitedrive.module.order.model;

import com.bmw.elitedrive.common.ComponentTest;
import com.bmw.elitedrive.common.TestContainers;
import com.bmw.elitedrive.module.client.dao.ClientRepository;
import com.bmw.elitedrive.module.extra.dao.ExtraRepository;
import com.bmw.elitedrive.module.order.dao.OrderExtrasRepository;
import com.bmw.elitedrive.module.order.dao.OrderRepository;
import com.bmw.elitedrive.module.order.dao.OrderService;
import com.bmw.elitedrive.module.vehicle.dao.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ComponentTest
public class OrderServiceImplTest extends TestContainers {
    // Still needs to setup flyway
    @Autowired
    private OrderService service;
    @Test
    @Sql({ "/data/create-client.sql", "/data/create-extras.sql", "/data/create-vehicle.sql" })
    void canCreateVehicleOrder() {
        //Given

        CreateVehicleOrderRequest request = CreateVehicleOrderRequest.builder()
                .clientId(1L)
                .vehicleId(1L)
                .extraIds(getExtras())
                .build();

        //When
        GetVehicleOrderResponse vehicleOrder = service.createVehicleOrder(request);

        //Then


    }

    private  Set<Long> getExtras(){
        Set<Long> extrasIds = new HashSet<>();
        extrasIds.add(1L);
        extrasIds.add(2L);
        return extrasIds;
    }
}