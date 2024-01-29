import render.GUI;

import javax.swing.*;

public class Simulation {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.startTimer();
        });


    }
}
