import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int row, col;
        final int LOWER_BOUND = 3;
        final int UPPER_BOUND = 10;
        int rowAverageSecondLargestIndex, colAverageSecondLargestIndex;
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.#"); // Formats floats to remove numbers after the tenth place

        // Get user input for the row and column of the Matrix
        row = validateInput(scanner, LOWER_BOUND, UPPER_BOUND, InputType.ROW);
        col = validateInput(scanner, LOWER_BOUND, UPPER_BOUND, InputType.COLUMN);

        System.out.println();

        int[][] randomMatrix = MatrixUtils.createRandomMatrix(row, col); // Create random matrix

        Matrix matrix = new Matrix(randomMatrix);
        MatrixUtils.printMatrix(matrix);

        float[] rowAverages = matrix.calculateRowAverages();
        float[] columnAverages = matrix.calculateColumnAverages();
        float matrixAverage = matrix.calculateMatrixAverage();

        System.out.printf("Row Averages: %s\nColumn Averages: %s\nMatrix Average: %.2f\n",
                Arrays.toString(rowAverages), Arrays.toString(columnAverages), matrixAverage);

        rowAverageSecondLargestIndex = MatrixUtils.findSecondLargest(rowAverages);
        colAverageSecondLargestIndex = MatrixUtils.findSecondLargest(columnAverages);

        System.out.println();
        MatrixUtils.printMatrixWithAverages(matrix, rowAverages, columnAverages, matrixAverage);

        System.out.println();
        System.out.printf("The row with the second largest average (%s) is the %s row (N=%d)\n",
                decimalFormat.format(rowAverages[rowAverageSecondLargestIndex]),
                formatPosition(rowAverageSecondLargestIndex + 1), rowAverageSecondLargestIndex + 1);
        System.out.printf("and the column with the second largest average (%s) is the %s column (M=%d)\n",
                decimalFormat.format(columnAverages[colAverageSecondLargestIndex]),
                formatPosition(colAverageSecondLargestIndex + 1), colAverageSecondLargestIndex + 1);

        System.out.println();

        int[][] modifiedMatrix = matrix.modifyMatrix();
        MatrixUtils.printMatrix(modifiedMatrix);

        int[] modifiedMatrixCount = MatrixUtils.countModifiedMatrix(modifiedMatrix);

        System.out.printf("The number of cells with values -1 is %d\n", modifiedMatrixCount[0]);
        System.out.printf("The number of cells with values +1 is %d\n", modifiedMatrixCount[1]);
        System.out.printf("The number of cells with values 0 is %d\n", modifiedMatrixCount[2]);

    }

    /**
     * Validates and receives user input
     *
     * @param scanner    Scanner object instance
     * @param lowerBound Minimum value that the user can input
     * @param upperBound Maximum value that the user can input
     * @param inputType  Describes the type of input (Row or Column)
     * @return The user's input
     */
    public static int validateInput(Scanner scanner, int lowerBound, int upperBound, InputType inputType) {
        int input = 0;
        String initialMessage = "", errorMessage = "";
        boolean validInput = false;

        // Initializes the initial and error message based on the input type
        switch (inputType) {
            case ROW:
                initialMessage = "Enter the row size: ";
                errorMessage = "Invalid input for row! Enter a row size between ";
                break;
            case COLUMN:
                initialMessage = "Enter the column size: ";
                errorMessage = "Invalid input for column! Enter a column size between ";
                break;
        }

        errorMessage += String.format("%d and %d: ", lowerBound, upperBound);   // Concatenating the lower and upper bound to the error message

        System.out.print(initialMessage);

        do {
            try {
                input = Integer.parseInt(scanner.nextLine()); // Get input and convert it to an integer

                // Checking if the current input is within the bound restrictions
                if (input >= lowerBound && input <= upperBound) {
                    validInput = true;
                } else {
                    System.out.print(errorMessage);
                }

            } catch (InputMismatchException | NumberFormatException e) {    // Catches wrongly inputted values such as letters and symbols
                System.out.print(errorMessage);
            }
        } while (!validInput);

        return input;
    }

    /**
     * Formats a number to its ordinal value
     * @param number A positive whole number representing an ordinal position
     * @return A formatted ordinal number
     */
    public static String formatPosition(int number) {
        if (number > 3 && number < 21) {
            return String.format("%dth", number);
        }

        int position = number % 10;

        switch (position) {
            case 1:
                return String.format("%dst", number);
            case 2:
                return String.format("%dnd", number);
            case 3:
                return String.format("%drd", number);
            default:
                return String.format("%dth", number);
        }
    }
}
