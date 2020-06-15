package game.scenes;

import engine.GameScene;
import engine.objects.Enemy;
import engine.objects.PlayerShip;
import javafx.scene.image.Image;

public class InGameScene extends GameScene {
    @Override
    public void init() {
        super.init();
        PlayerShip playerShip = new PlayerShip(500, 500);
        playerShip.activate();
        add(playerShip);
    }

    @Override
    public void update() {
        super.update();
    }
}
