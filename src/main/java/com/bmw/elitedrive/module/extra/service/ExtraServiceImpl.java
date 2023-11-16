package com.bmw.elitedrive.module.extra.service;

import com.bmw.elitedrive.common.exception.EntityExistsException;
import com.bmw.elitedrive.common.exception.EntityNotFoundException;
import com.bmw.elitedrive.module.extra.dao.ExtraRepository;
import com.bmw.elitedrive.module.extra.dao.ExtraService;
import com.bmw.elitedrive.module.extra.model.Extra;
import com.bmw.elitedrive.module.extra.model.CreateExtraRequest;
import com.bmw.elitedrive.module.extra.model.GetExtraResponse;
import com.bmw.elitedrive.module.extra.model.UpdateExtraRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

import static com.bmw.elitedrive.module.extra.dao.Mapper.mapToExtra;
import static com.bmw.elitedrive.module.extra.dao.Mapper.mapToGetExtraResponse;

@Service
@RequiredArgsConstructor
public class ExtraServiceImpl implements ExtraService {
    private final ExtraRepository extraRepo;
    @Override
    @Transactional
    public GetExtraResponse addExtra(CreateExtraRequest request) {
        extraRepo.findByNameIgnoreCase(request.getName())
                .ifPresent(c -> {
                    throw new EntityExistsException("This extra already exists in our records: " + request.getName());
                });
        Extra extra = mapToExtra(request);
        return mapToGetExtraResponse(extraRepo.saveAndFlush(extra));
    }

    @Override
    @Transactional
    public GetExtraResponse updateExtra(UpdateExtraRequest request) {
        Extra extra = extraRepo.findByNameIgnoreCase(request.getName())
                .orElseThrow(() -> new EntityNotFoundException("Extra not found with name: " + request.getName()));

        updateExtraFromRequest(extra, request);
        return mapToGetExtraResponse(extraRepo.saveAndFlush(extra));
    }

    private void updateExtraFromRequest(Extra extra, UpdateExtraRequest request) {
        Optional.ofNullable(request.getName())
                .ifPresent(extra::setName);
        Optional.ofNullable(request.getDescription())
                .ifPresent(extra::setDescription);
        Optional.ofNullable(request.getPrice())
                .ifPresent(extra::setPrice);
        Optional.ofNullable(request.getAdditionalCost())
                .ifPresent(extra::setAdditionalCost);
        Optional.ofNullable(request.getCompatibleModels()).
                ifPresent(extra::setCompatibleModels);

        if (request.getUnitQuantity() != 0) {
            extra.setUnitQuantity(request.getUnitQuantity());
        }
    }

}
