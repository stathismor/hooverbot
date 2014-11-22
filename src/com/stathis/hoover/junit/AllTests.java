package com.stathis.hoover.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GameLogicTest.class, InputParserTest.class })
public class AllTests {

}
