package pl.hfdp.factory.simple.stage1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BananaMilkShakeTest.class,
        ChocolateMilkShakeTest.class,
        StrawBerryMilkShakeTest.class,
        MilkShakeShopTest.class
})
public class MilkShakeSuite {
}