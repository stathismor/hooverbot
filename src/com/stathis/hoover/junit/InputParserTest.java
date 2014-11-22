package com.stathis.hoover.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stathis.hoover.game.Game;
import com.stathis.hoover.game.HooverBot;
import com.stathis.hoover.game.Solution;
import com.stathis.hoover.movement.Dimensions;
import com.stathis.hoover.movement.Map;
import com.stathis.hoover.movement.Movements;
import com.stathis.hoover.movement.Position;

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
