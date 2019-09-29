package pl.hfdp;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import pl.hfdp.strategy.stage1.DuckSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DuckSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
