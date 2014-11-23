package com.hooverbot.game;

import static com.hooverbot.util.Constant.Error.ERROR_MAP_IS_NOT_SQUARE;
import static com.hooverbot.util.Constant.Error.ERROR_POSITION_IS_OUT_OF_MAP_BOUNDS;

import com.hooverbot.exception.GameException;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.DrivingInstructions;
import com.hooverbot.movement.Position;
import com.hooverbot.transput.InputParser;
import com.hooverbot.transput.StandardOutputWriter;
import com.hooverbot.util.Logger;
import com.hooverbot.validation.IValidatable;

/**
 * This class is responsible for running the whole thing. It initialises the 
 * entities, runs the game and reports the results.
 */
public class Game {

    private static final String DEFAULT_INPUT_FILENAME = "input.txt";
    private String filename = "";
    private Solution solution = null;
    
    public static void main(String[] args) {
        Game game = new Game(DEFAULT_INPUT_FILENAME);
        game.run(true);
    }
    
    /**
     * Constructor for our game.
     * 
     * @param filename  The name of the file to be parsed (relative path + file name)
     */
    public Game(String filename) {
        this.filename = filename;
    }
    
    /**
     * Runs the game. It checks for errors and produces a solution.
     */
    public void run(boolean showResult) {
        InputParser parser = new InputParser(filename);
        boolean retVal = true;
        
        // Parse input file
        try {
            parser.parse();
        } catch (GameException e) {
            Logger.log(e);
            retVal = false;
        }
        
        // Get required game entities
        Map map = parser.getMap();    
        Position position = parser.getPosition();
        DrivingInstructions drivingInstructions = parser.getDrivingInstructions();
        
        if (retVal) {
            retVal = validate(map, position);
        }
        
        if (retVal) {
            Hooverbot hooverbot = new Hooverbot(map, position);
            solution = hooverbot.clean(drivingInstructions);            
            if (solution == null) {
                retVal = false;
            }
        }
        
        if (retVal && showResult) {
            StandardOutputWriter outputWriter = 
                                             new StandardOutputWriter(solution);
            outputWriter.write();
        }
    }
    
    /**
     * Validates the game's entities.
     * 
     * @param  map       Map to validate
     * @param  position  position to validate
     * @return boolean   true if all entities are valid, false otherwise
     */
    private boolean validate(IValidatable map, IValidatable position) {
        boolean isValid = true;

        if (isValid) {
            isValid = map.isValid();
            if (!isValid) {
                Logger.log(ERROR_MAP_IS_NOT_SQUARE);
            }
        }
        
        if (isValid) {
            isValid = position.isValid();
            if (!isValid) {
                Logger.log(ERROR_MAP_IS_NOT_SQUARE);
            }
        }
        
        return isValid;
    }
    
    /**
     * Returns the solution of the game. Used in unit testing.
     * 
     * @return Solution
     */
    public Solution getSolution() {
        return solution;
    }
}
