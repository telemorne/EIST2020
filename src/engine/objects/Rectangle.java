package engine.objects;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Rectangle extends GameObject {

    private int width, height;
    private Color color;

    /**
     * Constructs a Rectangle at the specified coordinates, with the specified width and height
     * and the specified color
     * @param x The x coordinate of the top left corner
     * @param y The y coordinate of the top left corner
     * @param width
     * @param height
     * @param color
     */
    public Rectangle(int x, int y, int width, int height, Color color) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Constructs a Rectangle at the specified coordinates, with the specified width and height
     * and the specified color
     * @param x The x coordinate of the top left corner
     * @param y The y coordinate of the top left corner
     * @param width
     * @param height
     * @param color
     * @param children
     */
    public Rectangle(int x, int y, int width, int height, Color color, GameObject... children) {
        super(x, y, children);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * Draws the Rectangle to the given GraphicsContext with the given offset
     * @param gc
     * @param offsetX
     * @param offsetY
     */
    @Override
    public void draw(GraphicsContext gc, int offsetX, int offsetY) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
        super.draw(gc, offsetX, offsetY);
    }
}
