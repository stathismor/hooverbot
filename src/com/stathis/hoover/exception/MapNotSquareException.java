package com.stathis.hoover.exception;

public class MapNotSquareException extends GameException {

    public MapNotSquareException() {
        super("X and y dimensions of the map are different");
    }
}
