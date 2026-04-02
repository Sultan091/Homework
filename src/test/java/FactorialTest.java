import Lesson7.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    void testFactorial(){
        assertEquals(120, factorial.calculate(5));
    }

    @Test
    void testNegative(){
        assertThrows(IllegalArgumentException.class, () -> {
            factorial.calculate(-1);
        });
    }
}
