package com.bmw.elitedrive.common.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;
@Data
@AllArgsConstructor
public class ApiError {
    private String message;
    private HttpStatus status;
    private Instant timeStamp;
}
