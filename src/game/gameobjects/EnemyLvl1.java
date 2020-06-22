package game.gameobjects;

import engine.objects.GameObject;
import javafx.scene.image.Image;

public class EnemyLvl1 extends Enemy {
    //TODO
    public EnemyLvl1(int x, int y, Image image, GameObject... children) {
        super(x, y, "virus.gif", children);
    }
}
