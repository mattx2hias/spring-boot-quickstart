package com.mattmatthias.quickstart.exception;

public class DummyAlreadyExistsException extends RuntimeException{

    public DummyAlreadyExistsException(String message) {
        super(message);
    }
}
