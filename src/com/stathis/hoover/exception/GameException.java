package com.stathis.hoover.exception;

public class GameException extends Exception {

    private static String lineNumStr = "\nat line number: "; 
    
    public GameException(String message) {
        super(message);
    }

    public GameException(String message, int lineNumber) {
        super(message + lineNumStr + lineNumber);
    }
    
    public GameException(String message, Exception e) {
        super(message, e);
    }
    
    public GameException(String message,
                         int lineNumber,
                         Exception e) {
        super(message + lineNumStr + lineNumber , e);
    }
}
