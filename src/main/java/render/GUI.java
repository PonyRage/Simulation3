package render;

import javax.swing.*;
import java.awt.*;



public class GUI extends JFrame{

        private JPanel panel;
        private final int COLS = 15;
        private final int ROWS = 1;
        private final int IMAGE_SIZE = 50;

        public GUI() {
            initPanel();
            initFrame();

        }

public void setImages() {
for (Images images : Images.values()) {
    images.image = getImage(images.name());
}
}

        public void initFrame() {
            pack();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setTitle("Симуляция");
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);

        }

        public void initPanel() {
            panel = new JPanel() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(getImage("sheep"), 0,0, this);
                }
            };
            panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE,
                    ROWS * IMAGE_SIZE));
            add(panel);
        }

        public Image getImage(String name) {
            String filename = "/img/" + name.toLowerCase() + ".png";
            ImageIcon icon = new ImageIcon(getClass().getResource(filename));
            return icon.getImage();
        }

    }

