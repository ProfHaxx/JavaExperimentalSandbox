package visual.colorlab;

import java.awt.*;

public class ColorLab {
    public static Color invertColor(Color color, boolean includeAlpha) {
        if(includeAlpha) {
            return new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue(), 255-color.getAlpha());
        } else {
            return new Color(255-color.getRed(), 255-color.getGreen(), 255-color.getBlue(), color.getAlpha());
        }
    }
}
