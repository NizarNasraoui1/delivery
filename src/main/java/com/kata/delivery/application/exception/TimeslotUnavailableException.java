package com.kata.delivery.application.exception;

public class TimeslotUnavailableException extends RuntimeException {
    public TimeslotUnavailableException(String message) {
        super(message);
    }
}
