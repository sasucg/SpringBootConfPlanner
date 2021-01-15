package com.project.demoproject.exception;

public class NotFoundConferenceException extends RuntimeException {

    public NotFoundConferenceException(String message) {
        super(message);
    }
}