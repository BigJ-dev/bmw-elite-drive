package com.bmw.elitedrive.module.extra.model;

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
@Table(name = "extra", schema = "elite_drive")
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long extraId;
    private String name;
    private String description;
    private BigDecimal additionalCost;
    private String compatibleModels;

    @ManyToMany(mappedBy = "extras")
    private Set<Order> orders;
}
