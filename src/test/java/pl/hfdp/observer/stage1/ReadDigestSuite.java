package pl.hfdp.observer.stage1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.hfdp.strategy.stage1.MallardDuckTest;
import pl.hfdp.strategy.stage1.RedHeadDuckTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ReadDigestWithSubscriptionTest.class,
        MovieDirectorTest.class,
        NewsPaperManTest.class,
        RaceCarDriverTest.class
})
public class ReadDigestSuite {
}