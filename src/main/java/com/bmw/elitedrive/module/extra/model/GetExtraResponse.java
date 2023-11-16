package com.bmw.elitedrive.module.extra.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class GetExtraResponse {
    private Long extraId;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal additionalCost;
    private int unitQuantity;
    private String compatibleModels;
}
