package com.stathis.hoover.game;

import java.util.ListIterator;

import com.stathis.hoover.movement.Map;
import com.stathis.hoover.movement.Movements;
import com.stathis.hoover.movement.Position;

public class HooverBot {

    private Map map = null;
    private Position position = null;
    private int dirtsCleaned = 0;
    
    public HooverBot(Map map, Position position) {
        this.map = map;
        this.position = position;
    }
    
    private void move(char direction) {
        
        Position previousPosition = position;
        
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
        
        if (position.isValid()) {
            doClean(position);
        } else {
            position = previousPosition;
        }
        
    }

    private void doClean(Position position) {
        if (map.hasDirt(position)) {
            dirtsCleaned ++;
        }
    }

    public Solution clean(Movements movements) {
        
        Solution solution = null;
        
        for (ListIterator<Character> iter = movements.listIterator(); iter.hasNext(); ) {
            Character direction = iter.next();
            move(direction);
        }

        solution = new Solution(position, dirtsCleaned);
        
        System.out.println(position.x + " " + position.y);
        System.out.println(dirtsCleaned);
        
        return solution;
    }
}
