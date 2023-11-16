package com.bmw.elitedrive.module.order.model;

import com.bmw.elitedrive.module.client.model.Client;
import com.bmw.elitedrive.module.extra.model.Extra;
import com.bmw.elitedrive.module.vehicle.model.Vehicle;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order", schema = "elite_drive")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Instant orderDate;
    private Instant estimatedDeliveryDate;
    private String status;
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicle;

    @ManyToMany
    @JoinTable(
            name = "order_extras",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "extraId")
    )
    private Set<Extra> extras;
}
