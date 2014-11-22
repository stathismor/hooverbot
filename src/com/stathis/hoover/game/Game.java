package com.stathis.hoover.game;

import static com.stathis.hoover.util.Constant.Error.ERROR_MAP_IS_NOT_SQUARE;
import static com.stathis.hoover.util.Constant.Error.ERROR_POSITION_IS_OUT_OF_MAP_BOUNDS;

import com.stathis.hoover.exception.GameException;
import com.stathis.hoover.movement.Map;
import com.stathis.hoover.movement.Movements;
import com.stathis.hoover.movement.Position;
import com.stathis.hoover.transput.InputParser;
import com.stathis.hoover.util.Logger;
import com.stathis.hoover.validation.Validatable;

public class Game {

    private static final String filename = "input.txt";
    
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
    
    public Game() {}
    
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
        Movements movements = parser.getMovements();
        
        if (retVal) {
            retVal = validate(map, position);
        }
        
        if (retVal) {
            HooverBot hooverbot = new HooverBot(map, position);
            hooverbot.clean(movements);            
        }
    }
    
    private boolean validate(Validatable map, Validatable position) {
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
