package com.citizen.service.adapter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(CitizenNotFoundException.class)
    public ResponseEntity<Object> handleCitizenNotFoundException(CitizenNotFoundException ex) {
       HttpStatus status = HttpStatus.NOT_FOUND;
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, status);
    }
}
