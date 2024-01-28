package render;


import java.util.ArrayList;

public class MapRanges {
    private static Coordinate size;
    private static ArrayList<Coordinate> allCoordinates;

    public static Coordinate getSize() {
        return size;
    }

    public static void setSize(Coordinate _size) {
        size = _size;
        allCoordinates = new ArrayList<Coordinate>();
        for (int y = 0; y < size.y; y++) {
            for (int x = 0; x < size.x; x++) {
                allCoordinates.add(new Coordinate(x, y));
            }
        }
    }
}
