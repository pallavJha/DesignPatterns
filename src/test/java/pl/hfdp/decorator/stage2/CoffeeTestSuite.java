package pl.hfdp.decorator.stage2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DarkRoastTest.class,
        HouseBlendTest.class,
        DecafTest.class,
        EspressoTest.class
})
public class CoffeeTestSuite {
}