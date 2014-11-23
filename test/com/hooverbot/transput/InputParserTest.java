package com.hooverbot.transput;

import static org.junit.Assert.assertEquals;
import static com.hooverbot.util.Constant.IOMedium.*;
import com.hooverbot.util.Constant.Error;

import org.junit.Test;

import com.hooverbot.exception.GameException;
import com.hooverbot.game.Game;
import com.hooverbot.game.HooverBot;
import com.hooverbot.game.Solution;
import com.hooverbot.movement.Dimensions;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.Movements;
import com.hooverbot.movement.Position;

public class InputParserTest {

    Game game = new Game();
    
    Dimensions dimensions = new Dimensions(5, 5);
    Map map = new Map(dimensions);
    Position position = new Position(1, 2, dimensions);
    HooverBot hooverbot = new HooverBot(map, position);
    
    @Test
    public void testRun() {

        map.applyDirt(1, 0);
        map.applyDirt(1, 0);
        map.applyDirt(2, 2);
        map.applyDirt(2, 3);
        
        Movements movements = new Movements("NNESEESWNWW");
        Solution correctSolution = new Solution(new Position(1,3), 1);
        Solution botSolution = hooverbot.clean(movements);
        assertEquals(correctSolution, botSolution);
    }
    
    @Test
    public void testRun2() {

        StringBuilder builder = new StringBuilder();
        builder.append("5 5").append("\n");
        builder.append("1 2").append("\n");
        builder.append("1 0").append("\n");
        builder.append("2 1").append("\n");
        builder.append("2 3").append("\n");
        builder.append("NNESEESWNWW").append("\n");

        IInputParser parser = InputParserFactory.createInputParser(STRING,
                                                                  builder.toString());
        try {
            Error error = parser.parse();
        } catch (GameException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Solution correctSolution = new Solution(parser.getPosition(), 1);
        Solution botSolution = hooverbot.clean(parser.getMovements());
        assertEquals(correctSolution, botSolution);
    }
}