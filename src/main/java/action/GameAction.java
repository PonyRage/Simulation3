package action;

import entities.Sheep;
import render.Coordinate;
import render.Images;
import render.MapRanges;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameAction {

    private Sheep sheep;
    private Timer timer;

    public GameAction(int cols, int rows, int sheeps) {
        MapRanges.setSize(new Coordinate(cols, rows));
        sheep = new Sheep(sheeps);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeMove();
            }
        });
    }

    public void start() {
        sheep.initSheeps();
        timer.start();
    }

    public void makeMove() {
        for (int i = 0; i < sheep.getTotalSheeps(); i++) {
            sheep.makeMove(Images.SHEEP);
        }
    }

    public Images getImages(Coordinate coordinate) {
        return sheep.get(coordinate);
    }
}
