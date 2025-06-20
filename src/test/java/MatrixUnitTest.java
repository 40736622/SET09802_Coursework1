import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixUnitTest {
    static Matrix matrix;

    @BeforeAll
    public static void init() {
        int[][] randMatrix = {
                { 1, 13, 135, 55, 701 },
                { 8, 416, 960, 24, 50 },
                { 55, 49, 499, 973, 321 },
                { 66, 284, 600, 4, 88 }
        };

        matrix = new Matrix(randMatrix);
    }

    @Test
    public void getRowTest() {
        assertEquals(4, matrix.getRow());
    }

    @Test
    public void getColumnTest() {
        assertEquals(5, matrix.getColumn());
    }

    @Test
    public void getMatrixTest() {
        int[][] exMatrix = {
                { 1, 13, 135, 55, 701 },
                { 8, 416, 960, 24, 50 },
                { 55, 49, 499, 973, 321 },
                { 66, 284, 600, 4, 88 }
        };

        assertArrayEquals(exMatrix, matrix.getMatrix());
    }

    @Test
    void calculateMatrixAverageTest() {
        float matrixAverage = 265.1f;
        assertEquals(matrixAverage, matrix.calculateMatrixAverage());
    }

    @Test
    public void calculateRowAverageTest() {
        float[] rowAverages = { 181f, 291.6f, 379.4f, 208.4f };
        assertArrayEquals(rowAverages, matrix.calculateRowAverages());
    }

    @Test
    public void calculateColumnAverageTest() {
        float[] columnAverages = { 32.5f, 190.5f, 548.5f, 264f, 290f };
        assertArrayEquals(columnAverages, matrix.calculateColumnAverages());
    }

    @Test
    public void modifyMatrixTest() {
        int[][] modifiedMatrix = {
                { -1, -1, -1, -1, 1 },
                { -1, 1, 1, -1, -1 },
                { 0, -1, 0, 1, 0 },
                { 0, 1, 1, -1, -1 }
        };

        assertArrayEquals(modifiedMatrix, matrix.modifyMatrix());
    }

}
