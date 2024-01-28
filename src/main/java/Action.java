import render.Coordinate;
import render.Images;
import render.MapRanges;


public class Action {

    public Action(int cols, int rows) {
        MapRanges.setSize(new Coordinate(cols, rows));
    }

    public Images getImages(Coordinate coordinate) {
        return Images.values()[(coordinate.x + coordinate.y) % Images.values().length];
    }
}
