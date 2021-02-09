package example;

import example.matrix.Matrix;
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

public class ZigzagTurtleTest {
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
    void walkZigZag() {
        ZigzagTurtle zigzagTurtle = new ZigzagTurtle(0, 0);
        zigzagTurtle.walk(matrix);
        assertEquals("7 8 7 4 6 8 1 5 7 8 4 2 0 8 8 2 7 8 5 8 7 8 6 1 0 9 9 0 0 4 5 7 0 0 3 2 9 3 6 7 2 2 ", out.toString());
    }
}