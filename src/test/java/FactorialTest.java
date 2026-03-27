import Lesson7.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    void testFactorial(){
        assertEquals(120, Factorial.calculate(5));
    }

    @Test
    void testNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(-1);
        });
    }
}
