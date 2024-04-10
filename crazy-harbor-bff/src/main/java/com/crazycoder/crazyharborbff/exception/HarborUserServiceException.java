package com.crazycoder.crazyharborbff.exception;


import com.crazycoder.crazyharborcommon.exception.BaseException;

public class HarborUserServiceException extends BaseException {

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
