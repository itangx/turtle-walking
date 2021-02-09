package example.turtle;

import example.matrix.Coordinate;
import example.matrix.Matrix;

public abstract class Turtle {
    protected Coordinate coordinate;

    public Turtle(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Turtle(int x, int y) {
        this(new Coordinate(x, y));
    }

    public abstract void walk(Matrix matrix);

    protected void walkUp() {
        this.coordinate.setX(this.coordinate.getX() - 1);
    }

    protected void walkDown() {
        this.coordinate.setX(this.coordinate.getX() + 1);
    }

    protected void walkLeft() {
        this.coordinate.setY(this.coordinate.getY() - 1);
    }

    protected void walkRight() {
        this.coordinate.setY(this.coordinate.getY() + 1);
    }
}
