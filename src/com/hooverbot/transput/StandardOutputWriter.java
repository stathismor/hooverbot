package com.hooverbot.transput;

import com.hooverbot.game.Solution;
import com.hooverbot.movement.Position;

public class StandardOutputWriter implements IOutputWriter {

    Solution solution =  null;
    
    public StandardOutputWriter(Solution solution) {
        this.solution = solution;
    }
    
    public String getOutput() {
        Position finalPosition = solution.getPosition();
        String output = finalPosition.x + " " + finalPosition.y + "\n" +
                        solution.getDirtsCleaned();
        return output;  
    }
    
    @Override
    public void write() {
        System.out.println(getOutput());
    }

}
