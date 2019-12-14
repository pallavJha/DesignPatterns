package pl.hfdp.factory.stage1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.hfdp.strategy.stage1.MallardDuckTest;
import pl.hfdp.strategy.stage1.RedHeadDuckTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BananaMilkShakeTest.class,
        ChocolateMilkShakeTest.class,
        StrawBerryMilkShakeTest.class
})
public class MilkShakeSuite {
}