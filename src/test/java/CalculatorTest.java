import Lesson7.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAll(){
        assertEquals(5, Calculator.add(2, 3));
    }

    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(10, 0);
        });
    }
}
