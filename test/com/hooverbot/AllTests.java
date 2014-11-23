package com.hooverbot;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hooverbot.game.FullTest;
import com.hooverbot.game.GameLogicTest;
import com.hooverbot.transput.InputParserTest;

@RunWith(Suite.class)
@SuiteClasses({ GameLogicTest.class, InputParserTest.class, FullTest.class })
public class AllTests {
    public static void main(String[] args) throws Exception {                    
       JUnitCore.main(
         "com.hooverbot.AllTests");            
    }
}
