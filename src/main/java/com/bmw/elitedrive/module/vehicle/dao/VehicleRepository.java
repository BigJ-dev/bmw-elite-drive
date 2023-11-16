package com.bmw.elitedrive.module.vehicle.dao;

import com.bmw.elitedrive.module.vehicle.model.VehicleJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleJpa, Long> {
    Optional<VehicleJpa> findByModelIgnoreCaseAndYear(String model, int year);
}
