package com.example.demo.exception;

public class InvalidSystemClock extends RuntimeException {

    public InvalidSystemClock(String msg) {
        super(msg);
    }
}
