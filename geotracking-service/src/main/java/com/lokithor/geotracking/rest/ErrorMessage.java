package com.lokithor.geotracking.rest;

/**
 * Created by lcruz on 2/13/17.
 */
public class ErrorMessage {

    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
