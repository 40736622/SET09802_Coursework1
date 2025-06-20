import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppUnitTest {
    @Test
    public void formatPositionTest1() {
        int number = 1;
        assertEquals("1st", App.formatPosition(number));
    }

    @Test
    public void formatPositionTest2() {
        int number = 2;
        assertEquals("2nd", App.formatPosition(number));
    }

    @Test
    public void formatPositionTest3() {
        int number = 3;
        assertEquals("3rd", App.formatPosition(number));
    }

    @Test
    public void formatPositionTest4() {
        int number = 10;
        assertEquals("10th", App.formatPosition(number));
    }

    @Test
    public void formatPositionTest5() {
        int number = 13;
        assertEquals("13th", App.formatPosition(number));
    }
}
