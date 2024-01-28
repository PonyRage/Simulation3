package render;

import javax.swing.*;
import java.awt.*;



public class GUI extends JFrame {

    private JPanel panel;
    private final int COLS = 15;
    private final int ROWS = 15;
    private final int IMAGE_SIZE = 50;

    public GUI() {
        MapRanges.setSize(new Coordinate(COLS, ROWS));
        setImages();
        initPanel();
        initFrame();

    }

    public void setImages() {
        for (Images images : Images.values()) {
            images.image = getImage(images.name());
        }
    }

    public void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Симуляция");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        pack();
    }

    public void initPanel() {
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for(Images images: Images.values()) {
                    Coordinate coordinate = new Coordinate(images.ordinal() * IMAGE_SIZE, 0);
                    g.drawImage((Image) images.image, coordinate.x, coordinate.y,  this);
                }

            }
        };
        panel.setPreferredSize(new Dimension(MapRanges.getSize().x * IMAGE_SIZE,
                MapRanges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    public Image getImage(String name) {
        String filename = "/img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

}

