package com.example.springcricket;

public class NotFoundException  extends RuntimeException {
    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
