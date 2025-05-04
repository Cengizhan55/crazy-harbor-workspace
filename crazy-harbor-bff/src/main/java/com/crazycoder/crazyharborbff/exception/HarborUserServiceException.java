package com.crazycoder.crazyharborbff.exception;


public class HarborUserServiceException extends RuntimeException {

    private final String serviceName;

    public HarborUserServiceException(String message, String serviceName) {
        super(message);
        this.serviceName = serviceName;
    }

    public HarborUserServiceException(String message) {
        super(message);
        this.serviceName = null;
    }

    public String getServiceName() {
        return serviceName;
    }
}
