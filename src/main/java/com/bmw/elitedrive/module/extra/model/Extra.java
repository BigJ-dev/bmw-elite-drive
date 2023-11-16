package com.bmw.elitedrive.module.extra.model;

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
@Table(name = "extra", schema = "elite_drive")
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraId;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal additionalCost;
    private int unitQuantity;
    private String compatibleModels;

    @ManyToMany(mappedBy = "extras")
    private Set<Order> orders;
}
