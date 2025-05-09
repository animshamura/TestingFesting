import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class) 
public class TestClass {
    private int a;
    private int b;
    private boolean expected;

    // Constructor to inject parameters
    public TestClass(int a, int b, boolean expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 101, 1000, true },
            { 5, 55, true},
            { 20, 27, false },
            { 2100, 4000, false },
            {7, 40, true }

        });
    }
    @Test
    public void testMultiply() {
        ProbabilisticFunctions prob = new ProbabilisticFunctions();
        assertEquals(expected, prob.isProbablyPrime(a, b));  // Verify that the multiplication is correct
    }
    
}
