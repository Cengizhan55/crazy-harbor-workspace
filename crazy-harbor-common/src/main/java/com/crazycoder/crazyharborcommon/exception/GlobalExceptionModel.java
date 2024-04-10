package com.crazycoder.crazyharborcommon.exception;

import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.Map;

public class GlobalExceptionModel {

    private final String message;
    private final HttpStatus httpStatus;
    private final Integer httpStatusCode;
    private final Throwable throwable;
    private final OffsetDateTime timestamp;
    private final Map<String,String> parameters;

    private final String applicationName;

    public GlobalExceptionModel(String message,
                                HttpStatus httpStatus,
                                Integer httpStatusCode, Throwable throwable,
                                OffsetDateTime timestamp, Map<String, String> parameters, String applicationName) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatusCode;
        this.throwable = throwable;
        this.timestamp = timestamp;
        this.parameters = parameters;
        this.applicationName = applicationName;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;

    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public Map<String,String> getParameters (){
        return parameters;
    }

    public String getApplicationName(){
        return applicationName;
    }
}