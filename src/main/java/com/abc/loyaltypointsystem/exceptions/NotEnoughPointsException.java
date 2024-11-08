package com.abc.loyaltypointsystem.exceptions;

public class NotEnoughPointsException extends RuntimeException {
    public NotEnoughPointsException(String s) {
        super(s);
    }
}
