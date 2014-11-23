package com.hooverbot.transput;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.hooverbot.exception.GameException;
import com.hooverbot.movement.Dimensions;
import com.hooverbot.movement.DrivingInstructions;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.Position;

/**
 * This class is responsible for parsing an input file, and do some
 * syntax-specific validation
 */
public class InputParser {

    private String filename = "";
    private Dimensions dimensions = null;
    private Position position = null;
    private Map map = null;
    private DrivingInstructions drivingInstructions = null;

    /**
     *  Constructor. Only copies in the filename.
     *  
     *  @param filename    The full filename (path + file name)
     */
    public InputParser(String filename) {
        this.filename = filename;
    }
    
    /**
     * Opens the file and parses it. Will throw syntax-specific validation errors. 
     * 
     */
    public void parse() throws GameException {
        
        BufferedReader reαder = null;
        File inputFile = new File(filename);

        if (!inputFile.exists() || !inputFile.isFile()) {
            throw new GameException("Input file not found");
        }

        try {
            reαder = new BufferedReader(new FileReader(filename));
            int lineNumber = 1; // Tells us where currentLine is at
            String currentLine = reαder.readLine().trim();
            String nextLine = reαder.readLine().trim();
            
            // Will help us get the data out
            InputProcessor processor = new InputProcessor();
            
            // We expect map dimensions are at the first line, so we try to get them
            dimensions = new Dimensions(processor.processDimensions(currentLine, 1));
            
            // We expect position to be at the second line
            position = new Position(processor.processPosition(nextLine, 2),
                                    dimensions);
            
            // Initialise the map according to the dimensions
            map = new Map(dimensions);

            // We parse the file line by line, and for each line we act
            // accordingly. We know the first two are going to be the dimensions
            // and position, but we need to know when we have reached the last
            // line, which is the driving instructions. Therefore, for each line we
            // are at, we peek at the next one to see if it is the last one.
            while (currentLine != null) {
                
                if (lineNumber > 2) {
                    
                    if (nextLine == null) {
                        drivingInstructions = 
                               processor.processDrivingInstructions(currentLine,
                                                                    lineNumber);
                    } else {
                        Point dirt = processor.processDirt(currentLine,
                                                           lineNumber);
                        map.applyDirt(dirt, lineNumber);
                    }
                }
                
                currentLine = nextLine;
                nextLine = reαder.readLine();
                lineNumber++;
            }
        } catch (IOException ioe) {
            throw new GameException("Error reading input file", ioe);
        }
        finally {
            try {
                reαder.close();
            } catch (IOException ioe) {
                throw new GameException("Error closing input file", ioe);
            }
        }
    }
    
    /**
     * Getter for dimensions.
     * @return Dimensions   The dimensions of the map
     */
    public Dimensions getDimensions() {
        return dimensions;
    }
    
    /**
     * Getter for position.
     * @return Position  The position of the robot
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Getter for the map
     * @return Map  Our map
     */
    public Map getMap() {
        return map;
    }
    
    /**
     * Getter for the driving instructions
     * @return DrivingInstructions  Our driving instructions
     */    
    public DrivingInstructions getDrivingInstructions() {
        return drivingInstructions;
    }
}