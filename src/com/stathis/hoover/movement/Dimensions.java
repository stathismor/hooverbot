package com.stathis.hoover.movement;

import java.awt.Point;

import com.stathis.hoover.validation.Validatable;

public class Dimensions extends Point implements Validatable {

    public Dimensions(Point position) {
        super(position);
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
