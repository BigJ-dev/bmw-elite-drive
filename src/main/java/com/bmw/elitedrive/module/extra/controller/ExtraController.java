package com.bmw.elitedrive.module.extra.controller;

import com.bmw.elitedrive.module.extra.dao.ExtraService;
import com.bmw.elitedrive.module.extra.model.CreateExtraRequest;
import com.bmw.elitedrive.module.extra.model.GetExtraResponse;
import com.bmw.elitedrive.module.extra.model.UpdateExtraRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ExtraController {
    private final ExtraService extraService;

    @PostMapping(value = "/extra")
    public ResponseEntity<GetExtraResponse> addExtra(@RequestBody CreateExtraRequest request) {
        return ResponseEntity.ok().body(extraService.addExtra(request));
    }

    @PutMapping(value = "/extra-update")
    public ResponseEntity<GetExtraResponse> updateExtra(@RequestBody UpdateExtraRequest request) {
        return ResponseEntity.ok().body(extraService.updateExtra(request));
    }
}
