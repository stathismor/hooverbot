package com.stathis.hoover.movement;

import java.awt.Point;

import com.stathis.hoover.exception.DirtOutOfMapBoundsException;
import com.stathis.hoover.validation.Validatable;

public class Map implements Validatable {

    private byte[][] map ;
    private Dimensions dimensions = null;
    
    public Map(Dimensions dimensions) {
        this.dimensions = dimensions;
        map = new byte[dimensions.x][dimensions.y];
        
        // Initialise
        for (int x = 0; x < dimensions.x; x ++) {
            for (int y = 0; y < dimensions.y; y++) {
                map[x][y] = 0;
            }
        }
    }
    
    public void applyDirt(Point point, int lineNumber)
                                           throws DirtOutOfMapBoundsException {
        if (point.x >= dimensions.x ||
            point.y >= dimensions.y) {
            throw new DirtOutOfMapBoundsException(lineNumber);
        }
        map[point.x][point.y] = 1;
    }
    
    public void applyDirt(int x, int y) {
        map[x][y] = 1;
    }
    
    /*
     * Used for debugging
     */
    public void print() {
        for (int x = 0; x < dimensions.x; x ++) { 
            for (int y = 0; y < dimensions.y; y++) { 
                 System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean hasDirt(Point position) {
        boolean hasDirt = false;
        
        if (map[position.x][position.y] == 1) {
            map[position.x][position.y] = 0;
            hasDirt = true;
        }
        
        return hasDirt;
    }
    
    @Override
    public boolean isValid() {
        return dimensions.isValid();
    }
}
