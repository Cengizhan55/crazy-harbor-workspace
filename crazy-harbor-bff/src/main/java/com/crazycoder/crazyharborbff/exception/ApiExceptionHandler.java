package com.crazycoder.crazyharborbff.exception;


import com.crazycoder.crazyharborcommon.exception.GlobalExceptionModel;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @Value("${spring.application.name}")
    private String applicationName;


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HarborUserServiceException.class)
    public ResponseEntity<Object> handleApiRequestException(HarborUserServiceException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;


        GlobalExceptionModel globalExceptionModel = new GlobalExceptionModel(
                e.getMessage(),
                httpStatus,
                httpStatus.value(), e.getCause(),
                OffsetDateTime.now(Clock.systemUTC()),
                Map.of("serviceName: ", e.getServiceName()),
                applicationName.toUpperCase()
        );

        return new ResponseEntity<>(globalExceptionModel, httpStatus);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Object> handleApiRequestException(InvalidFormatException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        GlobalExceptionModel globalExceptionModel = new GlobalExceptionModel(
                e.getMessage(),
                httpStatus,
                httpStatus.value(),
                e.getCause(),
                OffsetDateTime.now(Clock.systemUTC()),
                Collections.emptyMap(),
                applicationName.toUpperCase()
        );
        return new ResponseEntity<>(globalExceptionModel, httpStatus);
    }
}
