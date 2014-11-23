package com.hooverbot.game;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.hooverbot.UnitTester;
import com.hooverbot.game.Game;
import com.hooverbot.game.Solution;
import com.hooverbot.movement.Dimensions;
import com.hooverbot.movement.Position;

public class FullTest extends UnitTester {

    private static final String FULL_TESTS_DIRECTORY = "fullTests";    
    
    /**
     * Constructor
     */
    public FullTest() {
        super();
        fullTestsPath = new File(fullTestsPath, FULL_TESTS_DIRECTORY);
    }
    
    @Test
    public void FullTestSimple() {

        Game game = new Game(getFullFilename("01_fullTestSimple.txt"));
        game.run(false);
        Solution correctSolution = new Solution(new Position(3, 2,
                                                    new Dimensions(4, 4)),
                                                2);
        assertEquals(correctSolution, game.getSolution());
    }
}
