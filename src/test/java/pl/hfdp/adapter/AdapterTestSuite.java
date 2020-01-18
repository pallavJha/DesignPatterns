package pl.hfdp.adapter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.hfdp.command.command.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        EnumerationIteratorTest.class,
        IteratorEnumerationTest.class
})
public class AdapterTestSuite {
}