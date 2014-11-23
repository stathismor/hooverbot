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

public class Game {

    private static final String DEFAULT_INPUT_FILENAME = "input.txt";
    private String filename = "";
    
    public static void main(String[] args) {
        Game game = new Game(DEFAULT_INPUT_FILENAME);
        game.run();
    }
    
    public Game(String filename) {
        this.filename = filename;
    }
    
    public void run() {
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
        
        Solution solution =  null;
        if (retVal) {
            Hooverot hooverbot = new Hooverot(map, position);
            solution = hooverbot.clean(drivingInstructions);            
            if (solution == null) {
                retVal = false;
            }
        }
        
        if (retVal) {
            StandardOutputWriter outputWriter = 
                                             new StandardOutputWriter(solution);
            outputWriter.write();
        }
    }
    
    private boolean validate(IValidatable map, IValidatable position) {
        boolean isValid = true;

        if (!map.isValid()) {
            Logger.log(ERROR_MAP_IS_NOT_SQUARE);
        }
        
        if (!position.isValid()) {
            Logger.log(ERROR_POSITION_IS_OUT_OF_MAP_BOUNDS);
        }
        
        return isValid;
    }
}
