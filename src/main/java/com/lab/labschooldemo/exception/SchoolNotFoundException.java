package com.lab.labschooldemo.exception;

public class SchoolNotFoundException extends RuntimeException {
    public SchoolNotFoundException(String message) {
        super(message);
    }
}
