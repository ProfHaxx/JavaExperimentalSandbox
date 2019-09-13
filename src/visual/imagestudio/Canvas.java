package visual.imagestudio;

import javax.swing.*;

public class Canvas extends JFrame {
    ImageStudio studio;
    public Canvas() {
        setSize(100, 100);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void loadStudio(ImageStudio studio) {
        removeAll();
        this.studio = studio;
        add(studio);
    }

    public ImageStudio getStudio() {
        return studio;
    }
}
