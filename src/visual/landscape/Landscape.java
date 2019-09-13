package visual.landscape;

import visual.landscape.objects.AdvancedShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Landscape extends JFrame {
    int time; //1440
    ArrayList<AdvancedShape> shapes = new ArrayList<>();

    Landscape() {
        setTitle("Landscape Artwork");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        addObjects();
        startTime();
        paint();
    }

    private void addObjects() {
        //Sun

    }

    @Override
    public void paint(Graphics g) {
        for(AdvancedShape shape:shapes) {
            shape.paint((Graphics2D) g);
        }
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

    private void paint() {
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
