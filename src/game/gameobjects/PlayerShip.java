package game.gameobjects;

import engine.Controls;
import engine.collision.RectangleCollider;
import engine.objects.GameObject;
import game.Properties;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerShip extends GameObject {
    private boolean active = false;
    private final Image texture;
    public PlayerShip(int x, int y, GameObject... children) {
        super(x, y, children);
        texture = new Image(getClass().getClassLoader().getResource("ship.gif").toString());
    }

    public void activate() {
        active = true;
    }

    @Override
    public void update() {
        System.out.println(active);
        if(active) {
            System.out.println("active");
            x += Controls.getHorizontal();
            if(x<0) x=0;
            if(x> Properties.width-texture.getWidth()) x = Properties.width-texture.getWidth();
        }
        super.update();
    }

    @Override
    public void draw(GraphicsContext gc, int offsetX, int offsetY) {
        gc.drawImage(texture, (int)x+offsetX, (int)y+offsetY);
        super.draw(gc, (int)x+offsetX, (int)y+offsetY);
    }
}
