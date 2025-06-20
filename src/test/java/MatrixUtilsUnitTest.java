import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUtilsUnitTest {
    @Test
    public void createRandomMatrixTest() {
        int[][] randomMatrix = MatrixUtils.createRandomMatrix(3, 3);
        for (int matrixRow = 0; matrixRow < randomMatrix.length; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < randomMatrix[matrixRow].length; matrixColumn++) {
                if ((matrixRow + 1) % 2 == 0) {
                    assertEquals(0, randomMatrix[matrixRow][matrixColumn] % 2);
                } else {
                    assertEquals(1, randomMatrix[matrixRow][matrixColumn] % 2);
                }
            }
        }
    }

    @Test
    public void createRandomMatrixRowTest() {
        int[][] randomMatrix = MatrixUtils.createRandomMatrix(4,5);
        assertEquals(4, randomMatrix.length);
    }

    @Test
    public void createRandomMatrixColumnTest() {
        int[][] randomMatrix = MatrixUtils.createRandomMatrix(4,5);
        assertEquals(5, randomMatrix[0].length);
    }

    @Test
    public void countModifiedMatrixTest() {
        int[][] modifiedMatrix = {
                { -1, -1, -1, -1, 1 },
                { -1, 1, 1, -1, -1 },
                { 0, -1, 0, 1, 0 },
                { 0, 1, 1, -1, -1 }
        };

        int[] modifiedMatrixCount = { 10, 6, 4 };
        assertArrayEquals(modifiedMatrixCount, MatrixUtils.countModifiedMatrix(modifiedMatrix));
    }

    @Test
    public void findSecondLargestTest() {
        float[] averages = { 181f, 291.6f, 379.4f, 208.4f };
        assertEquals(1, MatrixUtils.findSecondLargest(averages));
    }

}
