package com.hooverbot.transput;

import java.io.File;

import org.junit.Test;

import com.hooverbot.UnitTester;
import com.hooverbot.exception.DirtOutOfMapBoundsException;
import com.hooverbot.exception.GameException;
import com.hooverbot.exception.InvalidDirectionException;
import com.hooverbot.exception.InvalidNumberOfPointCoordsException;
import com.hooverbot.exception.InvalidPointException;

public class InputParserTest extends UnitTester {
    
    private static final String INPUT_PARSER_TESTS_DIRECTORY = "inputParserTests";
    
    /**
     * Constructor
     */
    public InputParserTest() {
        super();
        fullTestsPath = new File(fullTestsPath, INPUT_PARSER_TESTS_DIRECTORY);
    }
    
    @Test(expected=InvalidNumberOfPointCoordsException.class)  
    public void InvalidNumberOfDimensionsTest() throws GameException {
        InputParser inputParser = 
                new InputParser(getFullFilename("01_InvalidNumberOfDimensions.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidPointException.class)  
    public void InvalidDimensionsTypeTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("02_InvalidDimensionsType.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidPointException.class)  
    public void NegativeDimenionsTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("03_NegativeDimensions.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidNumberOfPointCoordsException.class)  
    public void InvalidNumberOfPositionCoordsTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("04_InvalidNumberOfPositionCoords.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidPointException.class)  
    public void InvalidPositionCoordsTypeTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("05_InvalidPositionCoordsType.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidPointException.class)  
    public void NegativePositionCoordsTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("06_NegativePositionCoords.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidNumberOfPointCoordsException.class)  
    public void InvalidNumberOfDirtCoordsTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("07_InvalidNumberOfDirtCoords.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidPointException.class)  
    public void InvalidDirtCoordsTypeTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("08_InvalidDirtCoordsType.txt"));
        inputParser.parse();
    }

    @Test(expected=InvalidPointException.class)  
    public void NegativeDirtCoordsTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("09_NegativeDirtCoords.txt"));
        inputParser.parse();
    }
    
    @Test(expected=DirtOutOfMapBoundsException.class)  
    public void DirtOutOfMapBoundsTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("10_DirtOutOfMapBounds.txt"));
        inputParser.parse();
    }
    
    @Test(expected=InvalidDirectionException.class)  
    public void InvalidInstructionDirectionsTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("11_InvalidInstructionDirections.txt"));
        inputParser.parse();
    }
    
    @Test(expected=GameException.class)  
    public void FileNotFoundTest() throws GameException {
        InputParser inputParser = 
                      new InputParser(getFullFilename("IDontExist.txt"));
        inputParser.parse();
    }
}