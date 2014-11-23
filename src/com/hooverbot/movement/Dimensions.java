package com.hooverbot.movement;

import java.awt.Point;

import com.hooverbot.validation.IValidatable;

/**
 * Holds the dimensions of a map.
 */
public class Dimensions extends Point implements IValidatable {

    /**
     * Constructor using a Point.
     * 
     * @param position  Dimensions as a point
     */
    public Dimensions(Point position) {
        super(position);
    }

    /**
     * Constructor that uses x and y coordinates.
     * 
     * @param x  X coordinate
     * @param y  Y coordinate
     */
    public Dimensions(int x, int y) {
        super(x, y);
    }

    
    /**
     * Implements the interface. Map must be square, thus X and y dimensions
     * must match   .
     * 
     * @return boolean  true if map is square, false otherwise  
     */
    @Override
    public boolean isValid() {
        boolean isValid = true;
        if (x !=  y) {
            return false;
        }
        return isValid;
    }
}
