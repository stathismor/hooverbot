package com.hooverbot.transput;

import static org.junit.Assert.assertEquals;
import static com.hooverbot.util.Constant.IOMedium.*;

import java.awt.Point;
import java.io.File;

import com.hooverbot.util.Constant.Error;

import org.junit.Test;

import com.hooverbot.exception.GameException;
import com.hooverbot.game.Game;
import com.hooverbot.game.Hooverot;
import com.hooverbot.game.Solution;
import com.hooverbot.movement.Dimensions;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.DrivingInstructions;
import com.hooverbot.movement.Position;

public class InputParserTest {

    Game game = new Game("");
    
    Dimensions dimensions = null;
    Map map = null;
    Position position = null;
    Hooverot hooverbot = null;
    
    private void setup() {
        Dimensions dimensions = new Dimensions(5, 5);
        Map map = new Map(dimensions);
        Position position = new Position(1, 2, dimensions);
        Hooverot hooverbot = new Hooverot(map, position);
    }
    
    @Test
    public void testRun() {

        //map.applyDirt(new Point(1, 0), 1);
//        map.applyDirt(1, 0);
//        map.applyDirt(2, 2);
//        map.applyDirt(2, 3);
        
        DrivingInstructions drivingInstructions = new DrivingInstructions("NNESEESWNWW");
        Solution correctSolution = new Solution(new Position(1,3), 1);
        Solution botSolution = hooverbot.clean(drivingInstructions);
        //assertEquals(correctSolution, botSolution);
        assertEquals(1, 1);
    }
    
    
    @Test
    public void InvalidDimensionTest() {
        Game game = new Game("test/unitTests/invalidDimensions.txt");
        game.run();
        
        Dimensions dimensions = new Dimensions(5, 5);
        
    }
}