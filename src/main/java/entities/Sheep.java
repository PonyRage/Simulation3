package entities;

import render.Coordinate;
import render.Images;
import render.MapRanges;
import render.Matrix;

import java.util.Random;

public class Sheep {
    private Matrix sheepMatrix;
    private  int totalSheeps;

    public Sheep(int totalSheeps) {
        this.totalSheeps = totalSheeps;
        fixSheepsCount();
    }

    public void initSheeps() {
        sheepMatrix = new Matrix(Images.EMPTY);
        for (int i = 0; i < totalSheeps; i++) {
            placeSheep();
        }

    }
public Images get(Coordinate coordinate) {
        return sheepMatrix.get(coordinate);
}

private void fixSheepsCount() {
        int maxSheeps = MapRanges.getSize().x * MapRanges.getSize().y / 2;
        if (totalSheeps > maxSheeps)
            totalSheeps = maxSheeps;
}
    private void placeSheep() {
        while (true) {
            Coordinate coordinate = MapRanges.getRandomCoordinate();
            if (Images.SHEEP == sheepMatrix.get(coordinate))
                continue;
                sheepMatrix.set(coordinate, Images.SHEEP);
                break;
        }
    }
}
