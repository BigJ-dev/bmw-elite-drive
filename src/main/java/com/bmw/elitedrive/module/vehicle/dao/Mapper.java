package com.bmw.elitedrive.module.vehicle.dao;

import com.bmw.elitedrive.module.vehicle.model.CreateVehicleRequest;
import com.bmw.elitedrive.module.vehicle.model.GetVehicleResponse;
import com.bmw.elitedrive.module.vehicle.model.VehicleJpa;


public interface Mapper {
    static GetVehicleResponse mapVehicleJpaToResponse(VehicleJpa vehicleJpa) {
        return GetVehicleResponse.builder()
                .vehicleId(vehicleJpa.getVehicleId())
                .model(vehicleJpa.getModel())
                .year(vehicleJpa.getYear())
                .manufacturer(vehicleJpa.getManufacturer())
                .basePrice(vehicleJpa.getBasePrice())
                .standardFeatures(vehicleJpa.getStandardFeatures())
                .build();
    }
    static VehicleJpa mapRequestToVehicleJpa(CreateVehicleRequest request) {
        return  VehicleJpa.builder()
                .model(request.getModel())
                .year(request.getYear())
                .manufacturer(request.getManufacturer())
                .basePrice(request.getBasePrice())
                .standardFeatures(request.getStandardFeatures())
                .build();
    }
}
