package action;

import render.Coordinate;
import render.Images;
import render.MapRanges;


public class GameAction {

    public GameAction(int cols, int rows) {
        MapRanges.setSize(new Coordinate(cols, rows));
    }

    public Images getImages(Coordinate coordinate) {
        return Images.values()[(coordinate.x + coordinate.y) % Images.values().length];
    }
}
