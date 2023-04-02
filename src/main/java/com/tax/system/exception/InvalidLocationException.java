package com.tax.system.exception;

public class InvalidLocationException extends RuntimeException {

    private final String message;


    public InvalidLocationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
