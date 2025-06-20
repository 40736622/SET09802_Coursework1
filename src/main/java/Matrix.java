/**
 * Class representing a Matrix
 */
public class Matrix {
    private final int row;
    private final int column;
    private final int[][] matrix;

    Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        this.column = matrix[0].length;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    /**
     * Converts the Matrix to a string
     * @return A string representation of the Matrix
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int matrixRow = 0; matrixRow < this.row; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < this.column; matrixColumn++) {
                output.append(String.format("%7d", this.matrix[matrixRow][matrixColumn]));  // Formatting and adding the current item to the StringBuilder
            }

            output.append("\n");    // Adding newline after each row
        }

        return output.toString();
    }

    /**
     * Calculates the average of the whole matrix
     * @return The average of the whole matrix
     */
    public float calculateMatrixAverage() {
        float matrixAverage;
        int matrixSum = 0;

        // Looping over the matrix
        for (int matrixRow = 0; matrixRow < this.row; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < this.column; matrixColumn++) {
                matrixSum += this.matrix[matrixRow][matrixColumn];  // Summing all the elements of the matrix
            }
        }

        // Calculating the matrix average by dividing the sum by the total number of elements within the matrix
        matrixAverage = (float) matrixSum / (this.row * this.column);
        return matrixAverage;
    }

    /**
     * Calculates the average for each row of the matrix
     * @return An array, which consists of the average for each row of the matrix
     */
    public float[] calculateRowAverages() {
        float[] averagesArr = new float[this.row];      // Initializing an array to hold the row averages

        // Looping over the matrix by the rows
        for (int matrixRow = 0; matrixRow < this.row; matrixRow++) {
            int sum = 0;    // Initializing the sum to zero for each row

            for (int matrixColumn = 0; matrixColumn < this.column; matrixColumn++) {
                sum += matrix[matrixRow][matrixColumn];     // Summing all the items of the current row
            }

            averagesArr[matrixRow] = (float) sum / this.column;     // Calculating the average for the current row
        }

        return averagesArr;
    }

    /**
     * Calculates the average for each column of the matrix
     * @return An array, which consists of the average for each column of the matrix
     */
    public float[] calculateColumnAverages() {
        float[] averagesArr = new float[this.column];       // Initializing an array to hold the column averages

        // Looping over the matrix by the columns
        for (int matrixColumn = 0; matrixColumn < this.column; matrixColumn++) {
            int sum = 0;    // Initializing the sum to zero for each column

            for (int matrixRow = 0; matrixRow < this.row; matrixRow++) {
                sum += matrix[matrixRow][matrixColumn];     // Summing all the items of the current column
            }

            averagesArr[matrixColumn] = (float) sum / this.row;     // Calculating the average of the current column
        }

        return averagesArr;
    }

    /**
     * Creates a modified matrix of -1, 0 and 1 s based off the row and column averages
     * @return A 2D array which consists of -1, 0 and 1 s
     */
    public int[][] modifyMatrix() {
        int[][] modifiedMatrix = new int[this.row][this.column];
        float[] rowAverages = calculateRowAverages();
        float[] columnAverages = calculateColumnAverages();

        // Loops over the matrix
        for (int matrixRow = 0; matrixRow < this.row; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < this.column; matrixColumn++) {

                // Checks if the current matrix item is larger than the current row and column average
                if (this.matrix[matrixRow][matrixColumn] > columnAverages[matrixColumn] && this.matrix[matrixRow][matrixColumn] > rowAverages[matrixRow]) {
                    modifiedMatrix[matrixRow][matrixColumn] = 1;    // Assigns 1 to the modified matrix

                // Checks if the current matrix item is smaller than the current row and column average
                } else if (this.matrix[matrixRow][matrixColumn] < columnAverages[matrixColumn] && this.matrix[matrixRow][matrixColumn] < rowAverages[matrixRow]) {
                    modifiedMatrix[matrixRow][matrixColumn] = -1;      // Assigns -1 to the modified matrix

                // Otherwise, the current matrix item is either smaller or larger for only one of the current averages
                } else {
                    modifiedMatrix[matrixRow][matrixColumn] = 0;    // Assigns 0 to the modified matrix
                }
            }
        }

        return modifiedMatrix;
    }

}
