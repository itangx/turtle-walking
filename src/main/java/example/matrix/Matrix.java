package example.matrix;

import java.util.HashMap;
import java.util.Map;

public class Matrix {
    private int height;
    private int weight;
    private Map<Coordinate, Integer> coordinateValues;

    public Matrix(int[][] matrix) {
        this.height = matrix.length;
        this.weight = matrix[0].length;
        this.coordinateValues = new HashMap<>();
        for (int i=0; i<matrix.length ;i++) {
            for (int j=0; j<matrix[i].length ; j++) {
                this.coordinateValues.put(new Coordinate(i, j), matrix[i][j]);
            }
        }
    }

    public void printMatrix() {
        System.out.println("Matrix " + this.height + " x " + this.weight);
        for (Coordinate coordinate : coordinateValues.keySet()) {
            System.out.print(coordinateValues.get(coordinate) + " ");
            if (coordinate.getY() == this.weight - 1)
                System.out.println();
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Map<Coordinate, Integer> getCoordinateValues() {
        return coordinateValues;
    }
}
