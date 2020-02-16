package pl.hfdp.proxy.stage1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

interface IEmployee {

    String getName();

    void setName(String name);

    int getSalary();

    void setSalary(int salary);

    List<Employee> getSubordinates();

    void setSubordinates(List<Employee> subordinates);
}

class Employee implements IEmployee {

    private String name;

    private int salary;

    private List<Employee> subordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}

class EmployeeInvocationHandler implements InvocationHandler {

    private Employee employee;

    public EmployeeInvocationHandler(Employee employee) {
        this.employee = employee;
    }

    private List<Employee> fetchSubordinatesFromDatabase() throws InterruptedException {
        Thread.sleep(1000L);
        Employee e1 = new Employee();
        e1.setName("First");
        Employee e2 = new Employee();
        e2.setName("Second");
        return Arrays.asList(e1, e2);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("setSalary")) {
            throw new IllegalAccessException("The employee cannot update their own salary.");
        }
        if (method.getName().startsWith("getSubordinates")) {
            List<Employee> subordinatesFromDB = fetchSubordinatesFromDatabase();
            employee.setSubordinates(subordinatesFromDB);
        }
        return method.invoke(employee, args);
    }
}