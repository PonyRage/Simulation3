package action;

import render.Coordinate;
import render.Images;
import render.MapRanges;
import render.Matrix;


public class GameAction {

    Matrix entityMap;

    public GameAction(int cols, int rows) {
        MapRanges.setSize(new Coordinate(cols, rows));
    }

    public void start() {
        entityMap = new Matrix(Images.ALIEN);
    }

    public Images getImages(Coordinate coordinate) {
        return entityMap.get(coordinate);
    }
}
