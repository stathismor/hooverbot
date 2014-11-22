package com.hooverbot.transput;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}