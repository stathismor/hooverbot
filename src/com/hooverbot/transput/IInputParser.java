package com.hooverbot.transput;

import com.hooverbot.exception.GameException;
import com.hooverbot.movement.Dimensions;
import com.hooverbot.movement.Map;
import com.hooverbot.movement.Movements;
import com.hooverbot.movement.Position;
import com.hooverbot.util.Constant.Error;

public interface IInputParser {
    public Error parse() throws GameException;
    public Position getPosition();
    public Map getMap();
    public Movements getMovements();
}
