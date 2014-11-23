package com.hooverbot.movement;

/**
 * Interface to be used in foreach method of DrivingInstructions
 *
 */
public interface IDrivingInstructionValidator {

    /**
     * A function that will process a single driving instruction.
     * 
     * @param  instruction  A single driving instruction
     * @return boolean      false the instruction could not be processed successfully
     */
    public boolean process(Character instruction); 
}
