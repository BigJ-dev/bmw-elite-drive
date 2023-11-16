package com.bmw.elitedrive.module.extra.dao;

import com.bmw.elitedrive.module.extra.model.ExtraJpa;
import com.bmw.elitedrive.module.extra.model.CreateExtraRequest;
import com.bmw.elitedrive.module.extra.model.GetExtraResponse;

public interface Mapper {
    static GetExtraResponse mapExtraJpaToResponse(ExtraJpa extraJpa) {
        return GetExtraResponse.builder()
                .extraId(extraJpa.getExtraId())
                .name(extraJpa.getName())
                .description(extraJpa.getDescription())
                .price(extraJpa.getPrice())
                .additionalCost(extraJpa.getAdditionalCost())
                .unitQuantity(extraJpa.getUnitQuantity())
                .compatibleModels(extraJpa.getCompatibleModels())
                .build();
    }
    static ExtraJpa mapExtraRequestToExtraJpa(CreateExtraRequest request) {
        return  ExtraJpa.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .additionalCost(request.getAdditionalCost())
                .unitQuantity(request.getUnitQuantity())
                .compatibleModels(request.getCompatibleModels())
                .build();
    }
}
