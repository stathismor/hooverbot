package com.hooverbot.movement;

import java.awt.Point;

import com.hooverbot.exception.DirtOutOfMapBoundsException;
import com.hooverbot.util.Constant.MapTile;
import com.hooverbot.validation.IValidatable;

import static com.hooverbot.util.Constant.MapTile.*;

/**
 * Represents the map of our game. It does that by initially creating and empty
 * array with the size of the dimensions. It can be filled with dirts, or any
 * other elements that can be added in the future.
 * 
 * NOTE1: The implementation of this map can vary according to the requirements.
 * As it stands now, the bigger the map, the higher the memory allocation is 
 * going to be. This should not be an issue, unless someone requests an
 * insanely huge map. Assuming that we are the ones creating the input map 
 * dimensions, we will be all right.
 * 
 * NOTE2: As long as we keep the interface, we can change the implementation at
 * any time. Another approach would be to not allocate memory for each (empty or not)
 * tile of the map, but only hold the dimensions and use another structure for
 * the dirts, like a HashMap.
 */
public class Map implements IValidatable {

    private MapTile[][] map;
    private Dimensions dimensions = null;
    
    /**
     * Constructor
     * 
     * @param dimensions  Dimensions of the map
     */
    public Map(Dimensions dimensions) {
        this.dimensions = dimensions;
        map = new MapTile[dimensions.x][dimensions.y];
        
        // Initialise map
        for (int x = 0; x < dimensions.x; x ++) {
            for (int y = 0; y < dimensions.y; y++) {
                map[x][y] = MapTile.TILE_EMPTY;
            }
        }
    }
    
    /**
     * Adds the dirt to a certain map tile.
     * 
     * @param  point       Coordinates of the dirt
     * @param  lineNumber  The line number where the error occurred 
     * @throws DirtOutOfMapBoundsException
     */
    public void applyDirt(Point point, int lineNumber)
                                           throws DirtOutOfMapBoundsException {
        applyDirt(point.x, point.y, lineNumber);
    }
    
    /**
     * Adds the dirt to a certain map coordinates
     * 
     * @param x  The x coordinate
     * @param y  The y coordinate
     */
    public void applyDirt(int x, int y, int lineNumber) 
                                            throws DirtOutOfMapBoundsException {
        // This is no syntax validation per se, but needed to not get out of 
        // array bounds
        if (x >= dimensions.x ||
            y >= dimensions.y) {
            throw new DirtOutOfMapBoundsException(lineNumber);
        }
        map[x][y] = TILE_DIRT;
    }
 
    /**
     * Checks if a certain tile is dirty
     * 
     * @param  position  Position to check
     * @return boolean   Is dirty or not
     */
    public boolean hasDirt(Point position) {
        boolean hasDirt = false;
        
        if (map[position.x][position.y] == TILE_DIRT) {
            map[position.x][position.y] = TILE_EMPTY;
            hasDirt = true;
        }
        return hasDirt;
    }
    
    /**
     * Checks if map is valid
     * 
     * @return boolean true/false
     */
    @Override
    public boolean isValid() {
        return dimensions.isValid();
    }
}
