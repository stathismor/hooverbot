package com.hooverbot.transput;

import static com.hooverbot.util.Constant.Error.ERROR_OK;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.stream.ImageInputStream;

import com.hooverbot.exception.GameException;
import com.hooverbot.exception.InvalidNumberOfPointCoordsException;
import com.hooverbot.exception.InvalidPointException;
import com.hooverbot.movement.Dimensions;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.Movements;
import com.hooverbot.movement.Position;
import com.hooverbot.util.Constant.Error;

/**
 * This class is responsible for parsing an input file, and do some
 * syntax-specific validation
 */
public class InputParser implements IInputParser {

    private String filename = "";
    private Dimensions dimensions = null;
    private Position position = null;
    private Map map = null;
    private Movements movements = null;

    /**
     *  Constructor. Only copies in the filename.
     *  
     *  @param filename    The full filename (path + file name)
     */
    public InputParser(String filename) {
        this.filename = filename;
    }
    
    /**
     * Opens the file and parses it. 
     * 
     * @return the Error id, depending on whether files was opened and parsed
     *         successfully or not.
     */
    public Error parse() throws GameException {
        
        Error error = ERROR_OK;
        BufferedReader reαder = null;
        
        try {
            reαder = new BufferedReader(new FileReader(filename));
            int lineNumber = 1; // Tells us where currentLine is at
            String currentLine = reαder.readLine();
            String nextLine = reαder.readLine();
            
            // Map dimensions are in the first line, so we try to get them
            dimensions = new Dimensions(processDimensions(currentLine, 1));
            position = new Position(processPosition(nextLine, 2), dimensions);
            
            // Initialise the map according to the dimensions
            map = new Map(dimensions);

            // We parse the file line by line, and for each line we act
            // accordingly. We know the first two are going to be the dimensions
            // and position, but we need to know when we have reached the last
            // line, which is the robot movements. Therefore, for each line we
            // are at, we peek at the next one to see if it is the last one
            while (currentLine != null && error == ERROR_OK) {
                
                if (lineNumber > 2) {
                    if (nextLine == null) {
                        movements = new Movements(currentLine, lineNumber);
                    } else {
                        Point dirt = processDirt(currentLine, lineNumber);
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
        return error;
    }
    
    private Point processPoint(String line) throws GameException {
        String[] pointArray = line.split(" ");
        Point point = null;

        // Make sure we only have one x and one y 
        if (pointArray.length == 2) {
            try {
                // Must be integers
                int x = Integer.parseInt((pointArray[0]));  
                int y = Integer.parseInt((pointArray[1]));
                point = new Point(x, y);
            }
            catch (NumberFormatException nfe) {
                throw new InvalidPointException(nfe.getMessage());
            }
        } else {
            throw new InvalidNumberOfPointCoordsException();
        }
        return point;
    }

    private Point processPosition(String line,
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
                                   "The position coordinates are not integers",
                                   lineNumber,
                                   ipe);
        }
        return position;
    }
    
    private Point processDimensions(String line,
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
                                   "The dimension coordinates are not integers",
                                   lineNumber,
                                   ipe);
        }
        return dimensionsPoint;
    }
    
    private Point processDirt(String line, int lineNumber) throws GameException {
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
                                   "The dirt coordinates are not integers",
                                   lineNumber,
                                   ipe);
        }
        return dirtPoint;
    }
    
    public Dimensions getDimensions() {
        return dimensions;
    }
    
    public Position getPosition() {
        return position;
    }

    public Map getMap() {
        return map;
    }
    
    public Movements getMovements() {
        return movements;
    }
}
