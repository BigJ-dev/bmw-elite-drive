package com.bmw.elitedrive.common.error;

import com.bmw.elitedrive.common.exception.EntityExistsException;
import com.bmw.elitedrive.common.exception.EntityNotFoundException;
import com.bmw.elitedrive.common.util.TimeMachine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException(EntityExistsException ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(ex.getMessage(), HttpStatus.CONFLICT, TimeMachine.getNow()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityExistsException ex, WebRequest request) {
        return new ResponseEntity<>(new ApiError(ex.getMessage(), HttpStatus.NOT_FOUND, TimeMachine.getNow()), HttpStatus.NOT_FOUND);
    }
}
