package com.stathis.hoover.movement;

import java.awt.Point;

import com.stathis.hoover.validation.Validatable;

public class Position extends Point implements Validatable {
    
    private Dimensions dimensions = null;
    
    public Position(Point point, Dimensions dimensions) {
        this(point.x, point.y, dimensions);
    }
    
    public Position(int x, int y, Dimensions dimensions) {
        super(x, y);
        this.dimensions = dimensions;
    }

    public boolean isValid() {
        boolean isValid = true;
        
        if (x > dimensions.x ||
            y > dimensions.y) {
            return false;
        }
        
        return isValid;
    }
}
