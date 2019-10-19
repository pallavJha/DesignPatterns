package pl.hfdp.decorator.stage1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.hfdp.observer.stage1.MovieDirectorTest;
import pl.hfdp.observer.stage1.NewsPaperManTest;
import pl.hfdp.observer.stage1.RaceCarDriverTest;
import pl.hfdp.observer.stage1.ReadDigestWithSubscriptionTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DarkRoastTest.class,
        DecalWithSoyAndMochaTest.class,
        HouseBlendTest.class,
        HouseBlendWithMochaAndStreamedMilkTest.class
})
public class CoffeeTestSuite {
}