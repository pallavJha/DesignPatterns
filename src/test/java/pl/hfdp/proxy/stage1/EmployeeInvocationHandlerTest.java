package pl.hfdp.proxy.stage1;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeInvocationHandlerTest {

    private IEmployee employeeProxy;
    private Employee actualEmployee;

    @Before
    public void setUp() {
        actualEmployee = new Employee();
        employeeProxy = (IEmployee) Proxy.newProxyInstance(
                actualEmployee.getClass().getClassLoader(),
                actualEmployee.getClass().getInterfaces(),
                new EmployeeInvocationHandler(actualEmployee)
        );
    }

    @Test
    public void testNameAccess() {
        employeeProxy.setName("A very good Name");
        assertEquals("A very good Name", employeeProxy.getName());
    }

    @Test
    public void testSalarySetterAccess() {
        try {
            employeeProxy.setSalary(100000000);
        } catch (Exception e) {
            assertEquals(IllegalAccessException.class, e.getCause().getClass());
        }
    }

    @Test
    public void testSubordinates() {
        List<Employee> employeeList = employeeProxy.getSubordinates();
        assertEquals(2, employeeList.size());
        assertEquals("First", employeeList.get(0).getName());
        assertEquals("Second", employeeList.get(1).getName());
    }
}