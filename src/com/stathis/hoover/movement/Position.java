package com.stathis.hoover.movement;

import java.awt.Point;

import com.stathis.hoover.validation.Validatable;

public class Position extends Point implements Validatable {
    
    private Dimensions dimensions = null;
    
    public Position(Point point, Dimensions dimensions) {
        super(point);
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
