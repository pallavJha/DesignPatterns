package pl.hfdp.decorator.stage3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HouseBlendTest.class,
        EspressoTest.class,
        MochaTest.class,
        DoubleMochaTest.class,
        WhipTest.class
})
public class CoffeeTestSuite {
}