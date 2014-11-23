package com.hooverbot.transput;

import static com.hooverbot.util.Constant.IOMedium.*;

import java.io.FileReader;
import java.io.StringReader;

import com.hooverbot.util.Constant.IOMedium;

/**
 * Factory design pattern implementation for creating an input parser.
 *
 */
public class InputParserFactory {

    /**
     * Creator of the output writer
     * 
     * @param  ioMedium      Medium to parse from
     * @param  parameter     File/text to be parsed
     * @return IInputParser  An IOutputWriter class, depending on the type of
     *                       medium requested
     */
    public static IInputParser createInputParser(IOMedium ioMedium,
                                                 String parameter) {
        if (ioMedium == FILE) {
            return new InputParser<FileReader>(parameter, FileReader.class);
        } else if (ioMedium == STRING) {
            return new InputParser<StringReader>(parameter, StringReader.class);
        } else {
            throw new IllegalArgumentException("No such I/O medium");
        }
    }
}