package com.hooverbot.game;

import java.util.ListIterator;

import com.hooverbot.movement.Map;
import com.hooverbot.movement.DrivingInstructions;
import com.hooverbot.movement.Position;


/**
 * Meet our glorious robotic vacuum cleaner, Hooverbot! It can move on a map 
 * and clean dirts. Available for only £99.
 *
 */
public class Hooverbot {

    private Map map = null;
    private Position position = null;
    private int dirtsCleaned = 0;
    Position previousPosition = null;
    
    /**
     * Constructor
     * 
     * @param map       Robot is aware of the whole map.
     * @param position  Initial position of the robot
     */
    public Hooverbot(Map map, Position position) {
        this.map = map;
        this.position = position;
        previousPosition = new Position(position);
    }
    
    /**
     * Makes the robot move to a direction
     * 
     * @param direction  Direction to move towards
     */
    private void move(char direction) {
        
        previousPosition.setLocation(position);
        
        switch (direction) {
            case 'N':
                position.y++;
                break;
            case 'S':
                position.y--;
                break;
            case 'E':
                position.x++;
                break;                
            case 'W':
                position.x--;
                break;
            default:
                break;
        }
        
        // If a position is not in the map, the robot stays in the same place
        if (position.isValid()) {
            doClean(position);
        } else {
            position.setLocation(previousPosition);
        }
        
    }

    /**
     * Goes through the driving instructions and checks for dirts to clean.
     * 
     * @param  drivingInstructions  Our instructions
     * @return Solution             The solution of our game
     */
    public Solution clean(DrivingInstructions drivingInstructions) {
        
        Solution solution = null;
        
        // Check if initial position needs cleaning
        if (position.isValid()) {
            doClean(position);
        }
        
        for (ListIterator<Character> iter = drivingInstructions.listIterator();
             iter.hasNext(); ) {
            Character direction = iter.next();
            move(direction);
        }

        solution = new Solution(position, dirtsCleaned);
        
        return solution;
    }
    

    /**
     * Cleans dirt on a specific position
     * 
     * @param position  Position with potential dirt to be cleaned
     */
    private void doClean(Position position) {
        if (map.hasDirt(position)) {
            dirtsCleaned ++;
        }
    }
}
