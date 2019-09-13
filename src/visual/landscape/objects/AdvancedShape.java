package visual.landscape.objects;

import java.awt.*;

public abstract class AdvancedShape {
    /*
    * x and y describe the position of the object
    * width and height describe the bounds of the object
    * z_index describes the layer which the object is on
    */

    private int x, y, width, height, z_index;
    private Color color;

    public AdvancedShape() {
        z_index = 0;
    }

    public AdvancedShape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        z_index = 0;
    }

    public AdvancedShape(int x, int y, int width, int height, Color color, int z_index) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.z_index = z_index;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getZ_index() {
        return z_index;
    }

    public void setZ_index(int z_index) {
        this.z_index = z_index;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void paint(Graphics2D g);
}
