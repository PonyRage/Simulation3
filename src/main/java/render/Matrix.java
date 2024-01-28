package render;

import java.awt.*;

class Matrix {

    private Images[][] matrix;

    Matrix(Images defaultImage) {
        matrix = new Images[MapRanges.getSize().x][MapRanges.getSize().y];
        for (Coordinate coordinate : MapRanges.getAllCoordinates())
            matrix[coordinate.x][coordinate.y] = defaultImage;
    }

    Images get(Coordinate coordinate) {
        if (MapRanges.inRange(coordinate))
            return matrix[coordinate.x][coordinate.y];
        return null;
    }

    void set(Coordinate coordinate, Images images) {
        if (MapRanges.inRange(coordinate))
            matrix[coordinate.x][coordinate.y] = images;
    }
}
