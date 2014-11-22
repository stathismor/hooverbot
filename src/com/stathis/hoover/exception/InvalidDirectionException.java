package com.stathis.hoover.exception;


public class InvalidDirectionException extends GameException {

    public InvalidDirectionException(int lineNumber) {
        super("Invalid direction was given as part of the movements list", lineNumber);
        // TODO Auto-generated constructor stub
    }



}
