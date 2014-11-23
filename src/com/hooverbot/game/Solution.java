package com.hooverbot.game;

import com.hooverbot.movement.Position;

/**
 * Class that represent the solution
 */
public class Solution {

    private Position position = null;
    private int dirtsCleaned = 0;
    
    /**
     * Solution constructor.
     * 
     * @param position      Final position of the robot
     * @param dirtsCleaned  Dirts that have been cleaned
     */
    public Solution(Position position, int dirtsCleaned) {
        this.position = position;
        this.dirtsCleaned = dirtsCleaned;
    }
    
    /**
     * Checks that our solution matches another solution. Used in unit testing.
     */
    public boolean equals(Object object){
        boolean isEqual = false;
        
        if (object != null && object instanceof Solution) {
            Solution other = (Solution)object;
            isEqual = position.equals(other.getPosition()) &&
                      dirtsCleaned == other.getDirtsCleaned();
        }
        return isEqual;
    }
    
    /**
     * Getter for the position
     * @return Position
     */
    public Position getPosition() {
        return position;
    }
    
    /**
     * Getter for the position
     * @return Position
     */    
    public int getDirtsCleaned() {
        return dirtsCleaned;
    }
}
