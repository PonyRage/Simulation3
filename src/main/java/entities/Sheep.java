package entities;

import render.Coordinate;
import render.Images;
import render.Matrix;

public class Sheep {
    private Matrix sheepMatrix;
    private  int totalSheeps;

    public Sheep(int totalSheeps) {
        this.totalSheeps = totalSheeps;
    }

    public void initSheeps() {
        sheepMatrix = new Matrix(Images.EMPTY);
        placeSheep();
    }
public Images get(Coordinate coordinate) {
        return sheepMatrix.get(coordinate);
}
    private void placeSheep() {
        sheepMatrix.set(new Coordinate(4, 4), Images.SHEEP);
    }
}
