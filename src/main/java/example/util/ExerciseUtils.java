package example.util;

public abstract class ExerciseUtils {

    public ExerciseUtils() { }

    public static int[][] getGrid(String input) {
        String[] inputWithoutBracket = removeBracket(input, 2).split("],\\[");
        int[][] grid = new int[inputWithoutBracket.length][inputWithoutBracket[0].split(",").length];

        for (int i=0; i<inputWithoutBracket.length; i++) {
            String[] gridValues = inputWithoutBracket[i].split(",");
            for(int j=0; j<gridValues.length; j++) {
                grid[i][j] = Integer.parseInt(gridValues[j]);
            }
        }

        return grid;
    }

    public static int[] getStartPosition(String input) {
        String inputWithoutBracket = removeBracket(input, 1);
        String[] inputValueAsString = inputWithoutBracket.split(",");
        int[] position = new int[inputValueAsString.length];

        for(int i=0; i<inputValueAsString.length; i++) {
            position[i] = Integer.parseInt(inputValueAsString[i]);
        }

        return position;
    }

    private static String removeBracket(String str, int numberOfBracket) {
        return str.substring(numberOfBracket, str.length() - numberOfBracket);
    }
}
