package com.bmw.elitedrive.module.extra.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "extra", schema = "elite_drive")
public class ExtraJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraId;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal additionalCost;
    private int unitQuantity;
    private String compatibleModels;

}
