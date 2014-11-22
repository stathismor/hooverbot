package com.hooverbot.transput;

import static com.hooverbot.util.Constant.IOMedium.*;

import com.hooverbot.util.Constant.IOMedium;

/**
 * Factory design pattern implementation for creating an input parser.
 *
 */
public class InputParserFactory {

    /**
     * Creator of the output writer
     * 
     * @param  ioMedium      Medium to write solution to
     * @param  inputFile     File to be parsed
     * @return IInputParser  An IOutputWriter class, depending on the type of
     *                       medium requested
     */
    public static IInputParser createOutput(IOMedium ioMedium,
                                            String inputFile) {
        if (ioMedium == FILE) {
            return new InputParser(inputFile);
        } else {
            throw new IllegalArgumentException("No such currency");
        }
    }
}