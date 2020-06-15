package engine.objects;

public class RectangleCollider {
    private int x, y, width, height;

    /**
     * Constructs a Rectangle collider with the given location and size
     * @param x The x-coordinate of the top-left corner
     * @param y The y-coordinate of the top-left corner
     * @param width
     * @param height
     */
    public RectangleCollider(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @param other the other collider to detect if they are collided
     * @return returns true if it intersects the other Collider
     */
    public boolean intersects(RectangleCollider other) {
        return !(x >= other.x+other.width || other.x >= x+width || y <= other.y+other.height || other.y <= y+height);
    }
}
