package visual.landscape.objects;

import java.awt.*;

public class Rectangle extends AdvancedShape {

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    public Rectangle(int x, int y, int width, int height, Color color, int z_index) {
        super(x, y, width, height, color, z_index);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
