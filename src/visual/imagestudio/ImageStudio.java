package visual.imagestudio;

import javax.swing.*;
import java.awt.*;

public class ImageStudio extends JComponent {
    private JFrame frame = new JFrame();
    VirtualImage vi;
    public ImageStudio(VirtualImage vi) {
        frame.setTitle("Image Studio");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(vi.getResolution()[0], vi.getResolution()[1]);
        frame.add(this);
        this.vi = vi;
    }

    public void setImage(VirtualImage image) {
        this.vi = image;
    }

    public VirtualImage getImage() {
        return vi;
    }

    public void loadImage(Graphics2D g) {
        int width = vi.getWidth();
        int height = vi.getHeight();
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                g.setColor(vi.getData().get(i * height + j).getColor());
                g.fillRect(j, i, 1, 1);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        loadImage((Graphics2D) g);
    }
}
