package com.hooverbot.game;

import com.hooverbot.movement.Position;

public class Solution {

    private Position position = null;
    private int dirtsCleaned = 0;
    
    public Solution(Position position, int dirtsCleaned) {
        this.position = position;
        this.dirtsCleaned = dirtsCleaned;
    }
    
    public boolean equals(Object object){
        boolean isEqual = false;
        
        if (object != null && object instanceof Solution) {
            Solution other = (Solution)object;
            isEqual = position.equals(other.getPosition()) &&
                      dirtsCleaned == other.getDirtsCleaned();
        }
        return isEqual;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public int getDirtsCleaned() {
        return dirtsCleaned;
    }
}
