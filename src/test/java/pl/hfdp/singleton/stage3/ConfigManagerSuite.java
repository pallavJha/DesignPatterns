package pl.hfdp.singleton.stage3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ConfigManagerWithDoubleCheckedLockingTest.class,
        ConfigManagerWithEagerInitializationTest.class,
})
public class ConfigManagerSuite {
}