package com.bmw.elitedrive.module.extra.service;

import com.bmw.elitedrive.common.exception.EntityExistsException;
import com.bmw.elitedrive.common.exception.EntityNotFoundException;
import com.bmw.elitedrive.module.extra.dao.ExtraRepository;
import com.bmw.elitedrive.module.extra.dao.ExtraService;
import com.bmw.elitedrive.module.extra.model.ExtraJpa;
import com.bmw.elitedrive.module.extra.model.CreateExtraRequest;
import com.bmw.elitedrive.module.extra.model.GetExtraResponse;
import com.bmw.elitedrive.module.extra.model.UpdateExtraRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Optional;

import static com.bmw.elitedrive.module.extra.dao.Mapper.*;

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
        ExtraJpa extraJpa = mapExtraRequestToExtraJpa(request);
        return mapExtraJpaToResponse(extraRepo.saveAndFlush(extraJpa));
    }

    @Override
    @Transactional
    public GetExtraResponse updateExtra(UpdateExtraRequest request) {
        ExtraJpa extraJpa = extraRepo.findByNameIgnoreCase(request.getName())
                .orElseThrow(() -> new EntityNotFoundException("Extra not found with name: " + request.getName()));

        updateExtraFromRequest(extraJpa, request);
        return mapExtraJpaToResponse(extraRepo.saveAndFlush(extraJpa));
    }

    private void updateExtraFromRequest(ExtraJpa extraJpa, UpdateExtraRequest request) {
        Optional.ofNullable(request.getName())
                .ifPresent(extraJpa::setName);
        Optional.ofNullable(request.getDescription())
                .ifPresent(extraJpa::setDescription);
        Optional.ofNullable(request.getPrice())
                .ifPresent(extraJpa::setPrice);
        Optional.ofNullable(request.getAdditionalCost())
                .ifPresent(extraJpa::setAdditionalCost);
        Optional.ofNullable(request.getCompatibleModels()).
                ifPresent(extraJpa::setCompatibleModels);

        if (request.getUnitQuantity() != 0) {
            extraJpa.setUnitQuantity(request.getUnitQuantity());
        }
    }

}
