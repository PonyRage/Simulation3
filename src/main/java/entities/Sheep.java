package entities;

import render.Coordinate;
import render.Images;
import render.MapRanges;
import render.Matrix;

import java.util.ArrayList;
import java.util.List;

import static render.MapRanges.random;

public class Sheep {
    private Matrix sheepMatrix;
    private int totalSheeps;

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

    public void makeMove(Images sheepImage) {
        for (Coordinate currentCoordinate :
                getAllSheepCoordinates(sheepImage)) {
            Coordinate newCoordinate = getNewCoordinate(currentCoordinate);
            while (newCoordinate != null && MapRanges.inRange(newCoordinate) &&
                    sheepMatrix.get(newCoordinate) != Images.EMPTY) {
                newCoordinate = getNewCoordinate(currentCoordinate);
            }
            if (newCoordinate != null && MapRanges.inRange(newCoordinate)) {
                sheepMatrix.set(currentCoordinate, Images.EMPTY);
                sheepMatrix.set(newCoordinate, sheepImage);
            }
        }
    }

    private List<Coordinate> getAllSheepCoordinates(Images sheepImage) {
        List<Coordinate> sheepCoordiantes = new ArrayList<>();
        for (Coordinate coordinate : MapRanges.getAllCoordinates()) {
            if (sheepImage == sheepMatrix.get(coordinate)) {
                sheepCoordiantes.add(coordinate);
            }
        }
        return sheepCoordiantes;
    }

    private Coordinate getNewCoordinate(Coordinate currentCoordinate) {
        int xOffset = random.nextInt(3) - 1;
        int yOffset = random.nextInt(3) - 1;
        return new Coordinate(currentCoordinate.x + xOffset,
                currentCoordinate.y + yOffset);
    }

    private Coordinate findSheepCoordinate(Images sheepImage) {
        for (Coordinate coordinate : MapRanges.getAllCoordinates()) {
            if (sheepImage == sheepMatrix.get(coordinate)) {
                return coordinate;
            }
        }
        return null;
    }

    public int getTotalSheeps() {
        return totalSheeps;
    }
}
