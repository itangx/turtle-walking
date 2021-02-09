package example;

import example.matrix.Matrix;
import example.turtle.ClockwiseTurtle;
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

public class ClockwiseTurtleTest {
    private static int[][] grid;
    private static int[] startPosition;
    private static Matrix matrix;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    static void setup() {
        List<String> input = FileUtils.getFilePerLine("input1-2.txt");
        grid = ExerciseUtils.getGrid(input.get(0));
        startPosition = ExerciseUtils.getStartPosition(input.get(1));
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
    void walkClockWise() {
        ClockwiseTurtle clockwiseTurtle = new ClockwiseTurtle(startPosition[0] - 1, startPosition[1] - 1);
        clockwiseTurtle.walk(matrix);
        assertEquals("4 8 6 9 3 3 6 7 2 2 5 4 5 8 1 8 6 4 7 8 8 8 9 0 0 7 0 8 7 5 7 2 7 0 ", out.toString());
    }
}