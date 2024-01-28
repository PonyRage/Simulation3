package render;

import java.awt.*;

class Matrix {

 private Images[][] matrix;

    Matrix(Images defaultImage) {
        matrix = new Images[MapRanges.getSize().x][MapRanges.getSize().y];
        for (Coordinate coordinate : MapRanges.getAllCoordinates())
            matrix[coordinate.x][coordinate.y] = defaultImage;
    }
}
