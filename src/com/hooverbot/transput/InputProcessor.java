package com.hooverbot.transput;

import java.awt.Point;

import com.hooverbot.exception.GameException;
import com.hooverbot.exception.InvalidDirectionException;
import com.hooverbot.exception.InvalidNumberOfPointCoordsException;
import com.hooverbot.exception.InvalidPointException;
import com.hooverbot.movement.DrivingInstructions;

/**
 * This class fetches several entities of our game. It throws exceptions related
 * to the syntax of the input.
 */
public class InputProcessor {

    /**
     * Simple default constructor.
     */
    public InputProcessor() {}

    /**
     * A generic process method to be used for various entities.
     * 
     * @param  line   The line to be processed, as a string.
     * @return Point  Point to be processed
     * @throws GameException
     */
    private Point processPoint(String line) throws GameException {
        String[] pointArray = line.split(" ");
        Point point = null;
    
        // Make sure we only have one x and one y 
        if (pointArray.length == 2) {
            try {
                // Must be integers
                int x = Integer.parseInt((pointArray[0]));  
                int y = Integer.parseInt((pointArray[1]));
                    
                // There should not be any point with negative coordinates. 
                // Throw a generic error and will be caught just after.
                if (x < 0 || y < 0 ) {
                    throw new GameException("Point has negative coordinates");
                }
                    
                point = new Point(x, y);
            } catch (NumberFormatException | GameException e) {
                    throw new InvalidPointException(e.getMessage());
            }
        } else {
            throw new InvalidNumberOfPointCoordsException();
        }
        return point;
    }

    
    /**
     * Method to process our position.
     * 
     * @param  line           Position as a string
     * @param  lineNumber     Line number of the position string
     * @return Point          Position converted to a point
     * @throws GameException  Position should be consisted of two positive integer 
     *                        coordinates
     */    
    public Point processPosition(String line,
                                  int lineNumber) throws GameException {
        Point position = null;
        
        try {
            position = processPoint(line);
        } catch (InvalidNumberOfPointCoordsException itopce) {
            throw new InvalidNumberOfPointCoordsException(
                                       "Invalid number of position coordinates",
                                       lineNumber,
                                       itopce);
        } catch (InvalidPointException ipe) {
            throw new InvalidPointException(
                           "The position coordinates are not positive integers",
                           lineNumber,
                           ipe);
        }
        return position;
    }
    
    /**
     * Method to process our dimensions.
     * 
     * @param  line           Dimensions as a string
     * @param  lineNumber     Line number of the dimensions string
     * @return Point          Dimensions converted to a point
     * @throws GameException  Dimensions should be consisted of two numbers, and
     *                        be positive integers
     */
    public Point processDimensions(String line,
                                    int lineNumber) throws GameException {
        Point dimensionsPoint = null;
        
        try {
            dimensionsPoint = processPoint(line);
        } catch (InvalidNumberOfPointCoordsException inopce) {
            throw new InvalidNumberOfPointCoordsException(
                                      "Invalid number of dimension coordinates",
                                      lineNumber,
                                      inopce);
        } catch (InvalidPointException ipe) {
            throw new InvalidPointException(
                          "The dimension coordinates are not positive integers",
                          lineNumber,
                          ipe);
        }
        return dimensionsPoint;
    }
    
    /**
     * Method to process our dirt.
     *  
     * @param  line           Dirt as a string
     * @param  lineNumber     Line number of the dirt string
     * @return Point          Dirt converted to a point
     * @throws GameException  Dirt should be consisted of two positive integer 
     *                        coordinates
     */
    public Point processDirt(String line, int lineNumber) throws GameException {
        Point dirtPoint = null;
        
        try {
            dirtPoint  = processPoint(line);
        } catch (InvalidNumberOfPointCoordsException inopce) {
            throw new InvalidNumberOfPointCoordsException(
                                      "Invalid number of dirt coordinates",
                                      lineNumber,
                                      inopce);
        } catch (InvalidPointException ipe) {
            throw new InvalidPointException(
                               "The dirt coordinates are not positive integers",
                               lineNumber,
                               ipe);
        }
        return dirtPoint;
    }

    /**
     * Method to process our driving instructions.
     *  
     * @param  line           Driving instructions as a string
     * @param  lineNumber     Line number of the driving instructions
     * @return Point          Driving instructions converted to a point
     * @throws GameException  driving instructions should be consisted of specific
     *                        characters
     */
    public DrivingInstructions processMovements(String line, int lineNumber) 
                                              throws InvalidDirectionException {
        DrivingInstructions drivingInstructions = null;
        drivingInstructions  = new DrivingInstructions(line);
        if (drivingInstructions.checkSyntax()) {
            throw new InvalidDirectionException(lineNumber);
        }
        return drivingInstructions;
    }
    
}
