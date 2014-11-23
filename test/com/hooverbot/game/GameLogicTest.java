package com.hooverbot.game;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.io.File;

import org.junit.Test;

import com.hooverbot.UnitTester;
import com.hooverbot.exception.GameException;
import com.hooverbot.game.Game;
import com.hooverbot.game.Hooverbot;
import com.hooverbot.game.Solution;
import com.hooverbot.movement.Dimensions;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.DrivingInstructions;
import com.hooverbot.movement.Position;

public class GameLogicTest extends UnitTester {

    @Test
    public void SunnyDayTestSimple() throws GameException {

        Dimensions dimensions = new Dimensions(5, 5);
        Map map = new Map(dimensions);
        Position position = new Position(1, 2, dimensions);
        map.applyDirt(new Point(1, 0), 3);
        map.applyDirt(new Point(2, 2), 4);
        map.applyDirt(new Point(2, 3), 5);
        DrivingInstructions drivingInstructions = 
                                         new DrivingInstructions("NNESEESWNWW");
        Hooverbot hooverbot = new Hooverbot(map, position);
        
        Solution correctSolution = new Solution(new Position(1, 3, dimensions), 1);
        Solution botSolution = hooverbot.clean(drivingInstructions);
        assertEquals(correctSolution, botSolution);
    }
    
    @Test
    public void SunnyDayTestComplex() throws GameException {

        Dimensions dimensions = new Dimensions(7, 7);
        Map map = new Map(dimensions);
        Position position = new Position(1, 5, dimensions);
        map.applyDirt(new Point(0, 5), 3);
        map.applyDirt(new Point(0, 1), 4);
        map.applyDirt(new Point(2, 2), 5);
        map.applyDirt(new Point(2, 3), 6);
        map.applyDirt(new Point(3, 3), 7);
        map.applyDirt(new Point(4, 6), 8);
        map.applyDirt(new Point(5, 4), 9);
        map.applyDirt(new Point(6, 1), 10);
        map.applyDirt(new Point(1, 5), 11); // Initial position is dirty
        // Robot stays in its place at "WS <W> SSSEENENEENE <E> SSS"
        DrivingInstructions drivingInstructions = 
                                 new DrivingInstructions("WSWSSSEENENEENEESSS");
        Hooverbot hooverbot = new Hooverbot(map, position);
        
        Solution correctSolution = new Solution(new Position(6, 1, dimensions), 7);
        Solution botSolution = hooverbot.clean(drivingInstructions);
        assertEquals(correctSolution, botSolution);
    }
    
    @Test
    public void NoDirtsTest() throws GameException {

        Dimensions dimensions = new Dimensions(7, 7);
        Map map = new Map(dimensions);
        Position position = new Position(1, 5, dimensions);
        // Robot stays in its place at "WS <W> SSSEENENEENE <E> SSS"
        DrivingInstructions drivingInstructions = 
                                 new DrivingInstructions("WSWSSSEENENEENEESSS");
        Hooverbot hooverbot = new Hooverbot(map, position);
        
        Solution correctSolution = new Solution(new Position(6, 1, dimensions), 0);
        Solution botSolution = hooverbot.clean(drivingInstructions);
        assertEquals(correctSolution, botSolution);
    }
}
