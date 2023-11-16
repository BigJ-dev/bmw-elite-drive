package com.bmw.elitedrive.module.vehicle.dao;

import com.bmw.elitedrive.module.vehicle.model.CreateVehicleRequest;
import com.bmw.elitedrive.module.vehicle.model.GetVehicleResponse;
import com.bmw.elitedrive.module.vehicle.model.UpdateVehicleRequest;

public interface VehicleService {
    GetVehicleResponse addVehicle(CreateVehicleRequest request);
    GetVehicleResponse updateVehicle(UpdateVehicleRequest request);
}
