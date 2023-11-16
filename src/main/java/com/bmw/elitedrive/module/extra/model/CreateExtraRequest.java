package com.bmw.elitedrive.module.extra.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
public class CreateExtraRequest {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    private BigDecimal additionalCost;
    @NotNull
    private int unitQuantity;
    @NotNull
    private String compatibleModels;
}
