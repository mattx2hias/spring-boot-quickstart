package com.mattmatthias.quickstart.exception;

public class DummyDoesNotExist extends RuntimeException {

    public DummyDoesNotExist() {
        super("Dummy does not exist");
    }
}
