package com.solvd.exception;

public class BrowserNotSupportedException extends RuntimeException {

    public BrowserNotSupportedException(String message) {
        super(message);
    }

    public BrowserNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}