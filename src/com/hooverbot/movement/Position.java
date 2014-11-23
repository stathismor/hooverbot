package com.hooverbot.movement;

import java.awt.Point;

import com.hooverbot.validation.IValidatable;

public class Position extends Point implements IValidatable {
    
    private Dimensions dimensions = null;

    /**
     * Constructor using x and y coordinates
     * 
     * @param x  The x coordinate
     * @param y  The y coordinate
     */
    public Position(int x, int y, Dimensions dimensions) {
        super(x, y);
        this.dimensions = dimensions;
    }

    /**
     * Constructor using Point
     * 
     * @param point       The position
     * @param dimensions  The dimensions of the map
     */
    public Position(Point point, Dimensions dimensions) {
        this(point.x, point.y, dimensions);
    }

    /**
     * Implemented method. Checks if a position is inside the map.
     */
    @Override
    public boolean isValid() {
        boolean isValid = false;
        
        if (dimensions != null && 
            x >= 0 && x < dimensions.x &&
            y>= 0 && y < dimensions.y) {
            return true;
        }
        return isValid;
    }
    
    /**
     * Copy constructor
     * 
     * @param position  Another position
     */
    public Position(Position position) {
        super(position);
    }
}
