package pl.hfdp.component.stage2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HTMLPageTest.class,
        HTMLLeafElementTest.class,
        HTMLCompositeElementTest.class,
        BlankIteratorTest.class
})
public class HTMLElementTestSuite {
}