package com.hooverbot.transput;

import static com.hooverbot.util.Constant.IOMedium.*;

import com.hooverbot.game.Solution;
import com.hooverbot.util.Constant.IOMedium;

/**
 * Factory design pattern implementation for creating an output writer
 */
public class OutputWriterFactory {
    
    /**
     * Creator of the output writer
     * 
     * @param  ioMedium       Medium to write solution to
     * @param  solution       Solution of the game
     * @return IOutputWriter  An IOutputWriter class, depending on the type of
     *                        medium requested
     */
    public static IOutputWriter createOutputWriter(IOMedium ioMedium,
                                                   Solution solution) {
        if (ioMedium == STDOUT) {
            return new StandardOutputWriter(solution);
        } else {
            throw new IllegalArgumentException("No such currency");
        }
    }
}