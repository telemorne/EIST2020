package engine;

import engine.objects.GameObject;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Abstract parent class for all scenes.
 * A scene holds a list of all GameObjects that need to be updated and rendered.
 */
public abstract class GameScene {

    /**
     * A list of GameObjects present in the scene
     */
    private List<GameObject> objects;

    public GameScene(GameObject ... children) {
        objects = new ArrayList<GameObject>(Arrays.asList(children));
    }

    /**
     * Initialization of the scene
     */
    public void init() {

    }

    /**
     * Draws all the objects
     * @param gc The GraphicsContext that is drawn onto
     */
    public void draw(GraphicsContext gc) {
        objects.forEach(go -> go.draw(gc, 0, 0));
    }

    /**
     * Updates all contained GameObjects
     */
    public void update() {
        objects.forEach(GameObject::update);
    }

    /**
     * Adds a GameObject to Scene
     * @param objects
     */
    public void add(GameObject ... objects) {
        Collections.addAll(this.objects, objects);
    }


}
