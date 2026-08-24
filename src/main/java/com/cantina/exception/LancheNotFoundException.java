package com.cantina.exception;

public class LancheNotFoundException extends RuntimeException {
    public LancheNotFoundException(String message) {
        super(message);
    }
}
