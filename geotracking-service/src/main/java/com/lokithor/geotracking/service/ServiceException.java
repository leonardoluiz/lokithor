package com.lokithor.geotracking.service;

/**
 * Created by lcruz on 2/13/17.
 */
public class ServiceException extends RuntimeException {
    private String message;

    public ServiceException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
