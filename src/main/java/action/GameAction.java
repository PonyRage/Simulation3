package action;

import entities.Sheep;
import render.Coordinate;
import render.Images;
import render.MapRanges;
import render.Matrix;


public class GameAction {

   private Sheep sheep;

    public GameAction(int cols, int rows, int sheeps) {
        MapRanges.setSize(new Coordinate(cols, rows));
        sheep = new Sheep(sheeps);
    }

    public void start() {
        sheep.initSheeps();
    }

    public Images getImages(Coordinate coordinate) {
        return sheep.get(coordinate);
    }
}
