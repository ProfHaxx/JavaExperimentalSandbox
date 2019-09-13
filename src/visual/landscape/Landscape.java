package visual.landscape;

import javax.swing.*;
import java.awt.*;

class Landscape extends JFrame {
    int time; //1440

    Landscape() {
        setTitle("Landscape Artwork");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        startTime();
    }

    @Override
    public void paint(Graphics g) {

    }

    private void startTime() {
        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(10);
                } catch(InterruptedException ignored) {}
                time = (time < 1440) ? time + 1 : 0;
            }
        }).start();
    }

    private void rePaint() {
        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(10);
                } catch(InterruptedException ignored) {}
                repaint();
            }
        }).start();
    }
}
