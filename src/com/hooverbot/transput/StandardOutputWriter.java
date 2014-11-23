package com.hooverbot.transput;

import com.hooverbot.game.Solution;
import com.hooverbot.movement.Position;

/**
 * A class responsible for writing the solution to a standard output.
 *
 */
public class StandardOutputWriter {

    Solution solution =  null;
    
    /**
     * Constructor
     * 
     * @param solution  The solution of our game
     */
    public StandardOutputWriter(Solution solution) {
        this.solution = solution;
    }
    
    /**
     * Gets the output that will be written
     * 
     * @return String  The solution, as a string
     */
    public String getOutput() {
        Position finalPosition = solution.getPosition();
        String output = finalPosition.x + " " + finalPosition.y + "\n" +
                        solution.getDirtsCleaned();
        return output;  
    }
    
    /**
     * Writes to the standard output
     */
    public void write() {
        System.out.println(getOutput());
    }

}
