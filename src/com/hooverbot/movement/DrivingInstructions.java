package com.hooverbot.movement;

import java.util.LinkedList;
import java.util.ListIterator;

import com.hooverbot.validation.IValidatable;

/**
 * DrivingInstructions is a series of directions to follow on the map.
 */
public class DrivingInstructions extends LinkedList<Character> implements IValidatable {
    
    private static final int MINIMUM_ALLOWED_NUMBER_OF_MOVEMENTS = 1;
    
    /**
     * Constructor
     * 
     * @param instructionsStr  The driving instructions as a string 
     */
    public DrivingInstructions(String instructionsStr) {
        char[] instructionsArray = instructionsStr.toCharArray();
        
        for (int index = 0; index < instructionsArray.length; index++) {
            add(instructionsArray[index]);
        }       
    }
    
    /**
     * An inner class that is responsible for checking the correct syntax of 
     * directions given.
     */
    private class SystaxChecker implements IDrivingInstructionValidator {

        @Override
        public boolean process(Character direction) {
            return checkDirectionSyntax(direction);
        }
        
        /**
         * Checks the syntax of a single direction. Only N, S, E and W are allowed.
         * 
         * @param  direction  The direction provided
         * @return boolean    true if correct syntax, false otherwise
         */
        private boolean checkDirectionSyntax(Character direction) {
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
            return isValid;
        }
    }
    
    /**
     * Checks the instructions' syntax.
     * 
     * @return boolean  true if correct syntax, false otherwise 
     */
    public boolean checkSyntax() {
        return foreach(new SystaxChecker());
    }
    
    /**
     * This function wraps the iteration of our internal instructions' collection.
     * Several functions whose class follow the IDrivingInstructionValidator interface
     * can be run on each individual instruction. 
     * 
     * @param  drivingInstructionValidator  The object whose process function will be
     *                                      called for each instructions' element.
     * @return boolean                      false if any error occurred for any of
     *                                      the instructions' element.
     */
    public boolean foreach(IDrivingInstructionValidator drivingInstructionValidator) {
        boolean retVal = true;
        
        for (ListIterator<Character> iter = listIterator();
             iter.hasNext() && retVal == true
             ; ) {
            Character direction = iter.next();
            retVal = drivingInstructionValidator.process(direction);
        }
        
        return retVal;
    }

    /**
     * Implementation of the IDrivingInstructionValidator interface's function.
     * Validates the driving instructions. At least one instruction must be provided.
     */
    @Override
    public boolean isValid() {
        return (size() >= MINIMUM_ALLOWED_NUMBER_OF_MOVEMENTS);
    }
}
