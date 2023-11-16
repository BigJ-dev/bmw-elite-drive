package com.bmw.elitedrive.module.vehicle.service;

import com.bmw.elitedrive.common.exception.EntityExistsException;
import com.bmw.elitedrive.common.exception.EntityNotFoundException;
import com.bmw.elitedrive.module.vehicle.dao.VehicleRepository;
import com.bmw.elitedrive.module.vehicle.dao.VehicleService;
import com.bmw.elitedrive.module.vehicle.model.CreateVehicleRequest;
import com.bmw.elitedrive.module.vehicle.model.GetVehicleResponse;
import com.bmw.elitedrive.module.vehicle.model.UpdateVehicleRequest;
import com.bmw.elitedrive.module.vehicle.model.VehicleJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.bmw.elitedrive.module.vehicle.dao.Mapper.mapRequestToVehicleJpa;
import static com.bmw.elitedrive.module.vehicle.dao.Mapper.mapVehicleJpaToResponse;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepo;

    @Override
    @Transactional
    public GetVehicleResponse addVehicle(CreateVehicleRequest request) {
        vehicleRepo.findByModelIgnoreCaseAndYear(request.getModel(), request.getYear())
                .ifPresent(c -> {
                    throw new EntityExistsException("This vehicle model of this year already exists in our records");
                });

        VehicleJpa vehicleJpa = mapRequestToVehicleJpa(request);
        return mapVehicleJpaToResponse(vehicleRepo.saveAndFlush(vehicleJpa));
    }

    @Override
    @Transactional
    public GetVehicleResponse updateVehicle(UpdateVehicleRequest request) {
        VehicleJpa vehicleJpa = vehicleRepo.findByModelIgnoreCaseAndYear(request.getModel(), request.getYear())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with model and year."));

        updateVehicleFromRequest(vehicleJpa, request);
        return mapVehicleJpaToResponse(vehicleRepo.saveAndFlush(vehicleJpa));
    }

    private void updateVehicleFromRequest(VehicleJpa vehicle, UpdateVehicleRequest request) {
        Optional.ofNullable(request.getModel())
                .ifPresent(vehicle::setModel);
        Optional.ofNullable(request.getYear())
                .ifPresent(vehicle::setYear);
        Optional.ofNullable(request.getBasePrice())
                .ifPresent(vehicle::setBasePrice);
        Optional.ofNullable(request.getManufacturer())
                .ifPresent(vehicle::setManufacturer);
        Optional.ofNullable(request.getStandardFeatures())
                .ifPresent(vehicle::setStandardFeatures);
    }
}
