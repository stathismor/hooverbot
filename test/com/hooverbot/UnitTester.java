package com.hooverbot;

import java.io.File;

public class UnitTester {
    
    public static final String TEST_DIRECTORY = "test";
    public static final String UNIT_TESTS_DIRECTORY = "unitTests";
    protected File fullTestsPath = null;
    
    public UnitTester() {
        fullTestsPath = new File(TEST_DIRECTORY,
                                 UNIT_TESTS_DIRECTORY);
    }
    
    
    /**
     * Returns the full relative path with filename
     * 
     * @param  filename  Input filename
     * @return String    the filename with the full path prefixed
     */
    public String getFullFilename(String filename) {
        File fullFilename = new File(fullTestsPath, filename); 
        return fullFilename.toString();
    }
    
}
