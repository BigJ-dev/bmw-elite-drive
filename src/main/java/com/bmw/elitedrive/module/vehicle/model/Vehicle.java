package com.bmw.elitedrive.module.vehicle.model;

import com.bmw.elitedrive.module.order.model.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "vehicle", schema = "elite_drive")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;
    private String model;
    private BigDecimal basePrice;
    private String manufacturer;
    private String standardFeatures;

    @OneToMany(mappedBy = "vehicle")
    private Set<Order> orders;
}
