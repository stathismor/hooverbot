package com.hooverbot.util;

import com.hooverbot.util.Constant.Error;


/**
 * Class responsible for logging events
 */
public class Logger {

    /**
     * Empty constructor
     */
    public Logger() {}
    
    /**
     * Logs our exception
     * 
     * @param e  Exception to log
     */
    public static void log(Exception e) {
        System.err.println("[ERROR] - An error occured while running the game:");
        System.err.println(e.getMessage());
    }

    /**
     * Logs our error
     * 
     * @param error  Error to log
     */
    public static void log(Error error) {
        String errorMsg = "[ERROR] - An error occured while running the game:\n" +
                          error.toString();
        System.err.println(errorMsg);
    }

}
