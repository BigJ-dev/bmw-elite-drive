package com.bmw.elitedrive.module.vehicle.model;

import com.bmw.elitedrive.module.order.model.Order;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "vehicle", schema = "elite_drive")
public class VehicleJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private String model;
    private int year;
    private BigDecimal basePrice;
    private String manufacturer;
    private String standardFeatures;

    @OneToMany(mappedBy = "vehicleJpa")
    private Set<Order> orders;
}
