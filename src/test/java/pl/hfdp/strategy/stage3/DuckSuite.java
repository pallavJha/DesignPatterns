package pl.hfdp.strategy.stage3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        MallardDuckTest.class,
        RedHeadDuckTest.class,
        RubberDuckTest.class,
        FlyNoWayTest.class,
        FlyWithWingsTest.class
})
public class DuckSuite {
}