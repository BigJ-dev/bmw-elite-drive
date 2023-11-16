package com.bmw.elitedrive.module.extra.dao;

import com.bmw.elitedrive.module.extra.model.CreateExtraRequest;
import com.bmw.elitedrive.module.extra.model.GetExtraResponse;
import com.bmw.elitedrive.module.extra.model.UpdateExtraRequest;

public interface ExtraService {
    GetExtraResponse addExtra(CreateExtraRequest request);
    GetExtraResponse updateExtra(UpdateExtraRequest request);
}
