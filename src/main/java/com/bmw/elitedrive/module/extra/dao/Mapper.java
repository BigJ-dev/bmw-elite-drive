package com.bmw.elitedrive.module.extra.dao;

import com.bmw.elitedrive.module.extra.model.Extra;
import com.bmw.elitedrive.module.extra.model.CreateExtraRequest;
import com.bmw.elitedrive.module.extra.model.GetExtraResponse;

public interface Mapper {
    static GetExtraResponse mapToGetExtraResponse(Extra extra) {
        return GetExtraResponse.builder()
                .extraId(extra.getExtraId())
                .name(extra.getName())
                .description(extra.getDescription())
                .price(extra.getPrice())
                .additionalCost(extra.getAdditionalCost())
                .unitQuantity(extra.getUnitQuantity())
                .compatibleModels(extra.getCompatibleModels())
                .build();
    }
    static Extra mapToExtra(CreateExtraRequest request) {
        return  Extra.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .additionalCost(request.getAdditionalCost())
                .unitQuantity(request.getUnitQuantity())
                .compatibleModels(request.getCompatibleModels())
                .build();
    }
}
