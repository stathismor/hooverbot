package com.hooverbot.exception;

public class InvalidPointException extends GameException {

    public InvalidPointException(String message) {
        super(message);
    }
    
    public InvalidPointException(String message, int lineNumber, Exception e) {
        super(message, lineNumber, e);
    }
    
}
