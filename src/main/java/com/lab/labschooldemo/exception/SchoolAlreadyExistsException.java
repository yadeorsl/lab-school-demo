package com.lab.labschooldemo.exception;

public class SchoolAlreadyExistsException extends RuntimeException {
    public SchoolAlreadyExistsException(String message){
        super(message);
    }
}
