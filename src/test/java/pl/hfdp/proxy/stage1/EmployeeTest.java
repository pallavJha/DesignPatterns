package pl.hfdp.proxy.stage1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee();
    }

    @Test
    public void getName() {
        employee.setName("A very good Name");
        assertEquals("A very good Name", employee.getName());
    }

    @Test
    public void getSalary() {
        employee.setSalary(100);
        assertEquals(100, employee.getSalary());
    }

    @Test
    public void getSubordinates() {
        employee.setSubordinates(Arrays.asList(new Employee(), new Employee(), new Employee()));
        assertEquals(3, employee.getSubordinates().size());
    }
}