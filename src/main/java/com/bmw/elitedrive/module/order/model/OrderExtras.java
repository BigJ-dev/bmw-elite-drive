package com.bmw.elitedrive.module.order.model;

import com.bmw.elitedrive.module.extra.model.GetExtraResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderExtras {
   private List<GetExtraResponse> extras;
}
