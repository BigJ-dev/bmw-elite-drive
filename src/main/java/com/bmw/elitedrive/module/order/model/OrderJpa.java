package com.bmw.elitedrive.module.order.model;

import com.bmw.elitedrive.module.client.model.ClientJpa;
import com.bmw.elitedrive.module.extra.model.ExtraJpa;
import com.bmw.elitedrive.module.vehicle.model.VehicleJpa;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order", schema = "elite_drive")
public class OrderJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Instant orderDate;
    private Instant estimatedDeliveryDate;
    private String status;
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private ClientJpa clientJpa;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private VehicleJpa vehicleJpa;

    @OneToMany(mappedBy = "extraId")
    private List<ExtraJpa> extraJpaList;
}
