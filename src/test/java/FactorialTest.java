import Lesson7.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {
    @Test
    public void testFactorial(){
        assertEquals(Factorial.calculate(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
        public void testNegative(){
            Factorial.calculate(-1);
    }
}
