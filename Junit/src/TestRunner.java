import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        // Running the tests programmatically
        Result result = JUnitCore.runClasses(TestClass.class);

        // Checking if any tests failed
        for (Failure failure : result.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }

        // Printing the result of test run
        System.out.println("All tests passed: " + result.wasSuccessful());
    }
}

// Compile with
// javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar *.java
// Run
// java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar TestRunner