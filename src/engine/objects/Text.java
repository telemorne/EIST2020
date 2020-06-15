package engine.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Text extends GameObject {
    private String text;
    private int size;
    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Text(int x, int y, String text, int size, GameObject... children) {
        super(x, y, children);
        this.text = text;
        this.size = size;
        color = Color.WHITE;
    }

    @Override
    public void draw(GraphicsContext gc, int offsetX, int offsetY) {
        gc.setFont(Font.font(size));
        gc.setFill(color);
        gc.fillText(text, x+ offsetX, y + offsetY);
        super.draw(gc, (int)x+offsetX, (int)y+offsetY);
    }
}
