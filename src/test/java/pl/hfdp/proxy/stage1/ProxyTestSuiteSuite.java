package pl.hfdp.proxy.stage1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        EmployeeTest.class,
        EmployeeInvocationHandlerTest.class
})
public class ProxyTestSuiteSuite {
}