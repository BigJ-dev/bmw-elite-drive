package com.bmw.elitedrive.module.vehicle.controller;

import com.bmw.elitedrive.module.vehicle.dao.VehicleService;
import com.bmw.elitedrive.module.vehicle.model.CreateVehicleRequest;
import com.bmw.elitedrive.module.vehicle.model.GetVehicleResponse;
import com.bmw.elitedrive.module.vehicle.model.UpdateVehicleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping(value = "/vehicle")
    public ResponseEntity<GetVehicleResponse> addVehicle(@RequestBody CreateVehicleRequest request) {
        return ResponseEntity.ok().body(vehicleService.addVehicle(request));
    }

    @PutMapping(value = "/vehicle-update")
    public ResponseEntity<GetVehicleResponse> updateVehicle(@RequestBody UpdateVehicleRequest request) {
        return ResponseEntity.ok().body(vehicleService.updateVehicle(request));
    }
}
