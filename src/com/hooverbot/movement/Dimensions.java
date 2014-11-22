package com.hooverbot.movement;

import java.awt.Point;

import com.hooverbot.validation.IValidatable;

/**
 * Holds the dimensions of a map.
 */
public class Dimensions extends Point implements IValidatable {

    public Dimensions(Point position) {
        super(position);
    }

    public Dimensions(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isValid() {
        boolean isValid = true;
        if (x !=  y) {
            return false;
        }
        return isValid;
    }
}
