package example;

import example.matrix.Matrix;
import example.turtle.ClockwiseTurtle;
import example.turtle.ZigzagTurtle;
import example.util.ExerciseUtils;
import example.util.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixTest {
    private static int[][] grid;
    private static Matrix matrix;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    static void setup() {
        List<String> input = FileUtils.getFilePerLine("input1-1.txt");
        grid = ExerciseUtils.getGrid(input.get(0));
        matrix = new Matrix(grid);
    }

    @BeforeEach
    public void setStreams() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(originalOut);
    }

    @Test
    void printMatrix() {
        matrix.printMatrix();
        assertEquals("Matrix 6 x 7\n" +
                "7 2 0 1 0 2 9 \n" +
                "8 4 8 6 9 3 3 \n" +
                "7 8 8 8 9 0 6 \n" +
                "4 7 2 7 0 0 7 \n" +
                "6 5 7 8 0 7 2 \n" +
                "8 1 8 5 4 5 2 \n", out.toString());
    }
}