package game.scenes;

import engine.GameScene;
import game.gameobjects.PlayerShip;

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
