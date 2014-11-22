package com.hooverbot.game;

import static com.hooverbot.util.Constant.Error.ERROR_MAP_IS_NOT_SQUARE;
import static com.hooverbot.util.Constant.Error.ERROR_POSITION_IS_OUT_OF_MAP_BOUNDS;
import static com.hooverbot.util.Constant.IOMedium.*;

import com.hooverbot.exception.GameException;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.Movements;
import com.hooverbot.movement.Position;
import com.hooverbot.transput.IInputParser;
import com.hooverbot.transput.IOutputWriter;
import com.hooverbot.transput.InputParserFactory;
import com.hooverbot.transput.OutputWriterFactory;
import com.hooverbot.util.Logger;
import com.hooverbot.validation.IValidatable;

public class Game {

    private static final String filename = "input.txt";
    
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
    
    public Game() {}
    
    public void run() {
        IInputParser parser = InputParserFactory.createOutput(FILE, filename);
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
        
        Solution solution =  null;
        if (retVal) {
            HooverBot hooverbot = new HooverBot(map, position);
            solution = hooverbot.clean(movements);            
            if (solution == null) {
                retVal = false;
            }
        }
        
        if (retVal) {
            IOutputWriter outputWriter = 
                            OutputWriterFactory.createOutputWriter(STDOUT, solution);
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
