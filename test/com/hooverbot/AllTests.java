package com.hooverbot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hooverbot.game.GameLogicTest;
import com.hooverbot.transput.InputParserTest;

@RunWith(Suite.class)
@SuiteClasses({ GameLogicTest.class, InputParserTest.class })
public class AllTests {

}
