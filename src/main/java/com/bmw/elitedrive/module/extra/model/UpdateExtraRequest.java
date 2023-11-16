package com.bmw.elitedrive.module.extra.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class UpdateExtraRequest {
    @NotNull
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal additionalCost;
    private int unitQuantity;
    private String compatibleModels;
}
