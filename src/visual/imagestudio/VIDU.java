package visual.imagestudio;

import java.awt.*;

//Virtual Image Data Unit
public class VIDU {
    private Color color;
    public VIDU(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
