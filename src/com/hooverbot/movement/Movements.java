package com.hooverbot.movement;

import java.util.LinkedList;
import java.util.ListIterator;

import com.hooverbot.exception.InvalidDirectionException;
import com.hooverbot.validation.IValidatable;

public class Movements extends LinkedList<Character> implements IValidatable {
    
    int lineNumber = -1;
    
    public Movements(String movementStr, int lineNumber) {
                                         //throws InvalidDirectionException {
        this.lineNumber = lineNumber;
        char[] movementsArray = movementStr.toCharArray();
        
        for (int index = 0; index < movementsArray.length; index++) {
            add(movementsArray[index]);
        }
    
        for (ListIterator<Character> iter = listIterator(); iter.hasNext(); ) {
            Character direction = iter.next();
            validate(direction);
        }
        
//        while (!movementsList.isEmpty()) {
//            Character direction = movementsList.pop();
//            
//            validate(direction);
//        }
    }
    
    public Movements(String movementStr) {
        this(movementStr, 0);
    }
    
    private boolean validate(Character direction) { //throws InvalidDirectionException {
        boolean isValid = true;
        
        switch (direction) {
            case 'N':
            case 'S':
            case 'E':
            case 'W':
                // We're good
                break;
            default:
                isValid = false;
        }
        
        if (!isValid) {
            //throw new InvalidDirectionException(lineNumber);
        }
        return isValid;
        
    }

    @Override
    public boolean isValid() {
        boolean isValid = true;
        
        for (ListIterator<Character> iter = listIterator(); iter.hasNext(); ) {
            Character direction = iter.next();
            validate(direction);
        }
        
        return isValid;
    }
}
