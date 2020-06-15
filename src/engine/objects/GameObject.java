package engine.objects;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Abstract superclass for all Objects that can be added to a scene
 */
public abstract class GameObject {
    protected double x, y;

    protected RectangleCollider collider;

    /**
     * An arraylist that can hold children of the GameObject if it has any
     */
    private List<GameObject> children;

    /**
     * Instanciates a GameObject without any children
     */
    public GameObject(int x, int y) {
        children = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    /**
     * Instanciates a GameObject with the specified children
     * @param children The children the GameObject should hold
     */
    public GameObject(int x, int y, GameObject ... children) {
        this.children = Arrays.asList(children);
        this.x = x;
        this.y = y;
    }

    /**
     * Draws all children.
     * Override if something should be drawn
     * @param gc
     */
    public void draw(GraphicsContext gc, int offsetX, int offsetY) {
        children.forEach(go -> go.draw(gc, offsetX + (int)x, offsetY + (int)y));
    }

    /**
     * Updates all children.
     * Override if something should be updated
     */
    public void update() {
        children.forEach(GameObject::update);
    }

    /**
     * Adds the specified GameObject(s) as children
     * @param children
     */
    public void addChildren(GameObject ... children) {
        this.children.addAll(Arrays.asList(children));
    }

    public List<GameObject> getChildren() {
        return children;
    }

    public RectangleCollider getCollider() {
        return collider;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
