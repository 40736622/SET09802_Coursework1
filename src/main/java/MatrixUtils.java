import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * Utility class providing helper methods for matrix-related functionality
 */
public class MatrixUtils {

    private MatrixUtils() {
    }

    /**
     * Creates a random matrix where the even rows have even values and odd rows have odd values
     *
     * @param row    Represents the number of rows for the matrix
     * @param column Represents the number of columns for the matrix
     * @return A matrix with random values
     */
    public static int[][] createRandomMatrix(int row, int column) {
        int UPPER_BOUND = 1001; // Limits matrix to have values ranging from 0 to 1000
        Random random = new Random();

        int[][] matrix = new int[row][column];  // Initializing matrix (2D array) based on row and column

        // Looping over initialized matrix
        for (int matrixRow = 0; matrixRow < matrix.length; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < matrix[matrixRow].length; matrixColumn++) {
                int num = random.nextInt(UPPER_BOUND);

                // Checking if the current row of the matrix is even
                // Note: Current matrix row is the current row index + 1
                if ((matrixRow + 1) % 2 == 0) {
                    // Generating even value for even rows
                    while (num % 2 != 0) {
                        num = random.nextInt(UPPER_BOUND);
                    }
                } else {
                    // Generating odd value for odd rows
                    while (num % 2 != 1) {
                        num = random.nextInt(UPPER_BOUND);
                    }
                }

                matrix[matrixRow][matrixColumn] = num;  // Assigning generated number to the matrix
            }
        }

        return matrix;
    }

    /**
     * Counts the total number of -1, 0 and 1 s within a 2D array
     *
     * @param matrix 2D array containing only of -1, 0 and 1
     * @return An array which consists of the total number of -1, 0 and 1 s within the 2D array
     */
    public static int[] countModifiedMatrix(int[][] matrix) {
        int negativeOneCount = 0, positiveOneCount = 0, zeroCount = 0;

        // Looping over the matrix
        for (int matrixRow = 0; matrixRow < matrix.length; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < matrix[matrixRow].length; matrixColumn++) {
                if (matrix[matrixRow][matrixColumn] == 1) {     // Checks if the current item is 1
                    positiveOneCount++;
                } else if (matrix[matrixRow][matrixColumn] == -1) {     // Checks if the current item is -1
                    negativeOneCount++;
                } else if (matrix[matrixRow][matrixColumn] == 0) {      // Checks if the current item is 0
                    zeroCount++;
                }
            }
        }

        return new int[]{negativeOneCount, positiveOneCount, zeroCount};
    }

    /**
     * Prints Matrix object instance to the console
     *
     * @param matrix Matrix object instance
     */
    public static void printMatrix(Matrix matrix) {
        System.out.println(matrix);
    }

    /**
     * Prints 2D array to the console
     *
     * @param matrix 2d array
     */
    public static void printMatrix(int[][] matrix) {
        Matrix tempMatrix = new Matrix(matrix); // Creating a Matrix object instance from the 2D array
        System.out.println(tempMatrix);
    }

    /**
     * Prints a matrix with its row, column and total averages to the console
     *
     * @param matrix         A 2D array
     * @param rowAverages    Row averages for the matrix
     * @param columnAverages Column averages for the matrix
     * @param totalAverage   Total average for the matrix
     */
    public static void printMatrixWithAverages(Matrix matrix, float[] rowAverages, float[] columnAverages, float totalAverage) {
        StringBuilder output = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        int[][] tempMatrix = matrix.getMatrix();

        // Loops over the matrix
        for (int matrixRow = 0; matrixRow < matrix.getRow(); matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < matrix.getColumn(); matrixColumn++) {
                output.append(String.format("%10d", tempMatrix[matrixRow][matrixColumn])); // Adds and format the current matrix item to the StringBuilder
            }
            output.append(String.format("%10s", decimalFormat.format(rowAverages[matrixRow]))).append("\n"); // Adds the current row average and a newline to the end of the matrix row
        }

        for (int index = 0; index < columnAverages.length; index++) {
            output.append(String.format("%10s", decimalFormat.format(columnAverages[index]))); // Adds and format the column averages to a new row
        }

        output.append(String.format("%10s", decimalFormat.format(totalAverage)));   // Adds and format the total averages to the last row
        System.out.println(output);
    }

    /**
     * Finds the second-largest item within an array
     * @param arr An array of a Matrix's row or column averages
     * @return The index of second-largest item
     */
    public static int findSecondLargest(float[] arr) {
        float[] arrCopy = Arrays.copyOf(arr, arr.length);   // Copying the array
        Arrays.sort(arrCopy);   // Sorting the copied array

        int secondLargestIndex = -1;
        float secondLargest = Float.MIN_VALUE;
        float largest = arrCopy[arrCopy.length - 1];  // Setting the largest value to last item of the copied array after it has been sorted

        // Looping over the original array
        for (int index = 0; index < arr.length; index++) {
            // Checking if the current item is larger than the current second-largest value
            // and smaller than the largest item
            if (arr[index] > secondLargest && arr[index] < largest) {
                secondLargest = arr[index];
                secondLargestIndex = index;
            }
        }

        return secondLargestIndex;
    }

}
