package example.turtle;

import example.matrix.Coordinate;
import example.matrix.Matrix;

import java.util.Map;

public class ClockwiseTurtle extends Turtle {
    public ClockwiseTurtle(int x, int y) {
        super(x, y);
    }

    @Override
    public void walk(Matrix matrix) {
        if (matrix.getHeight() < coordinate.getX() || matrix.getWeight() < coordinate.getY())
            throw new IllegalStateException("The turtle standing out of matrix!");
        int bottomWall = matrix.getHeight() - 1;
        int rightWall = matrix.getWeight() - 1;
        int leftWall = 0;
        int topWall = coordinate.getX() + 1;
        Map<Coordinate, Integer> coordinateValues = matrix.getCoordinateValues();

        while (true) {
            walkRightToEndOfWall(coordinateValues, rightWall);
            rightWall--;
            if (bottomWall < topWall) break;

            walkDownToEndOfWall(coordinateValues, bottomWall);
            bottomWall--;
            if (rightWall < leftWall) break;

            walkLeftToEndOfWall(coordinateValues, leftWall);
            leftWall++;
            if (bottomWall < topWall) break;

            walkUpToEndOfWall(coordinateValues, topWall);
            topWall++;
            if (rightWall < leftWall) break;
        }
    }

    private void walkRightToEndOfWall(Map<Coordinate, Integer> coordinateValues, int rightWall) {
        System.out.print(coordinateValues.get(coordinate) + " ");
        if (coordinate.getY() == rightWall) {
            walkDown();
            return;
        }
        walkRight();
        walkRightToEndOfWall(coordinateValues, rightWall);
    }

    private void walkDownToEndOfWall(Map<Coordinate, Integer> coordinateValues, int bottomWall) {
        System.out.print(coordinateValues.get(coordinate) + " ");
        if (coordinate.getX() == bottomWall) {
            walkLeft();
            return;
        }
        walkDown();
        walkDownToEndOfWall(coordinateValues, bottomWall);
    }

    private void walkLeftToEndOfWall(Map<Coordinate, Integer> coordinateValues, int leftWall) {
        System.out.print(coordinateValues.get(coordinate) + " ");
        if (coordinate.getY() == leftWall) {
            walkUp();
            return;
        }
        walkLeft();
        walkLeftToEndOfWall(coordinateValues, leftWall);
    }

    private void walkUpToEndOfWall(Map<Coordinate, Integer> coordinateValues, int topWall) {
        System.out.print(coordinateValues.get(coordinate) + " ");
        if (coordinate.getX() == topWall) {
            walkRight();
            return;
        }
        walkUp();
        walkUpToEndOfWall(coordinateValues, topWall);
    }

    private boolean isWallOverlapped(int leftWall, int topWall, int bottomWall, int rightWall) {
        return bottomWall < topWall || leftWall < rightWall;
    }
}
