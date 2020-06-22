package game.gameobjects;

import engine.objects.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.net.URL;

public abstract class Enemy extends GameObject {
    private javafx.scene.image.Image image;


    public Enemy(int x, int y, String imageurl, GameObject... children) {
        super(x, y, children);
        this.image=image;
    }

    @Override
    public void draw(GraphicsContext gc, int offsetX, int offsetY) {
        gc.drawImage(image, x+offsetX, y+offsetY);
        super.draw(gc, (int)offsetX+(int)x, offsetY+(int)y);
    }
}
