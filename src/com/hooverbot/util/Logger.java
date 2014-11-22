package com.hooverbot.util;

import com.hooverbot.util.Constant.Error;

public class Logger {

    public Logger() {}
    
    public static void log(Exception e) {
        System.err.println("[ERROR] - An error occured while running the game:");
        System.err.println(e.getMessage());
    }
    
    public static void log(Error error) {
        String errorMsg = "[ERROR] - An error occured while running the game:\n" +
                          error.toString();
        System.err.println(errorMsg);
    }

}
