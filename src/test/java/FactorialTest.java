import Lesson7.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    Factorial factorial = new Factorial();
    @Test
    public void testFactorial(){
        assertEquals(factorial.calculate(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
        public void testNegative(){
            factorial.calculate(-1);
    }
}
