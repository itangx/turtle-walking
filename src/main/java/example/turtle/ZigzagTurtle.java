package example.turtle;

import example.matrix.Coordinate;
import example.matrix.Matrix;

import java.util.Map;

public class ZigzagTurtle extends Turtle {
    public ZigzagTurtle(int x, int y) {
        super(x, y);
    }

    @Override
    public void walk(Matrix matrix) {
        if (matrix.getHeight() < coordinate.getX() || matrix.getWeight() < coordinate.getY())
            throw new IllegalStateException("The turtle standing out of matrix!");
        int height = matrix.getHeight() - 1;
        int weight = matrix.getWeight() - 1;
        Map<Coordinate, Integer> coordinateValues = matrix.getCoordinateValues();
        while (true) {
            walkDownToEndOfWall(coordinateValues, height);
            if (coordinate.getY() > weight) break;

            walkUpToEndOfWall(coordinateValues);
            if (coordinate.getY() > weight) break;
        }
    }

    private void walkDownToEndOfWall(Map<Coordinate, Integer> coordinateValues, int height) {
        System.out.print(coordinateValues.get(coordinate) + " ");
        if (coordinate.getX() == height) {
            walkRight();
            return;
        }
        walkDown();
        walkDownToEndOfWall(coordinateValues, height);
    }

    private void walkUpToEndOfWall(Map<Coordinate, Integer> coordinateValues) {
        System.out.print(coordinateValues.get(coordinate) + " ");
        if (coordinate.getX() == 0) {
            walkRight();
            return;
        }
        walkUp();
        walkUpToEndOfWall(coordinateValues);
    }
}