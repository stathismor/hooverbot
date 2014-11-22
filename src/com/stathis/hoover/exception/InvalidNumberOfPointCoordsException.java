package com.stathis.hoover.exception;

public class InvalidNumberOfPointCoordsException extends GameException {

    public InvalidNumberOfPointCoordsException() {
        super("The point numbers are not integers");
    }

    public InvalidNumberOfPointCoordsException(
                                  String message,
                                  int lineNumber,
                                  Exception e) {
        super(message, lineNumber, e);
    }

}
