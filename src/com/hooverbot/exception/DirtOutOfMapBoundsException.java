package com.hooverbot.exception;


public class DirtOutOfMapBoundsException extends GameException {

    public DirtOutOfMapBoundsException(int lineNumber) {
        super("Dirt coordinates are outside of the map bounds", lineNumber);
    }
    
}
