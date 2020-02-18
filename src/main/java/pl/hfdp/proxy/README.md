In this tutorial we'll be learning about the **Proxy Design Pattern**.

You might already be knowing about the reverse proxy servers, like, Nginx, or the proxy object from Hibernate, a popular
ORM used in Java.

When a Hibernate Entity has an element marked to be fetched Lazily, like,
```java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="USER_ID")
private UserLazy user;
```

then it is only filled up from the database whenever you call the getter function for that attribute, i.e. `getUser();`.
However, you actually don't write code for that as the plain and simple getter just returns the user object:
```java
public UserLazy getUser() {
    return this.user;
}
```

So, how did Hibernate filled up this variable, `user`, when you called the method `getUser`?

It's like that because Hibernate doesn't actually work on the class that you've provided rather it creates a _Proxy_
over it and it becomes the job of the proxy to fill up the elements that are lazily fetched.

A proxy is class that is used to interface something else. 
The proxy could interface to anything: 
- a network connection, 
- a large object in memory, 
- a file, or some other resource that is expensive or impossible to duplicate. 

In short, a proxy is a wrapper or agent object that is being called by the client to access the real serving object 
behind the scenes.

Let's take one more example. The HR software allows you to access your profile you can call several methods, like, 
`getName` to get your name or `setLeaves` to update your leaves. But it will never allow you to set your salary. Your
access to the method `setSalary` is denied. How? because it didn't pass the Employee object to you instead it created a
proxy over the employee object and that proxy is controlling the access. It is called protection proxy.

Now, let's start coding. We will be creating an Employee class and one Employee Proxy class. We'll be using **Invocaiton
Handler** over here. 

`InvocationHandler` is a part of the `java.lang.reflect` package and it lets you create a proxy class on the fly that 
implements one or more interfaces and forwards method invocations to a class that you specify.

This is our Employee interface, i.e., `IEmployee`
```java
interface IEmployee {

    String getName();

    void setName(String name);

    int getSalary();

    void setSalary(int salary);

    List<Employee> getSubordinates();

    void setSubordinates(List<Employee> subordinates);
}
```

and this interface is being implemented by our `Employee` class:
```java
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

    // the access to method should be denied by the employee
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // getting the subordinates is not so straightforward
    // because we've to fetch that from the RDBMS database
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}
```

So, we've to take care of two scenarios:
1. Access to the method `setSalary` must be denied.
2. When someone calls `getSubordinates`, the attribute `subordinates` must be filled up.

To achieve this, we've create the following class:
```java
class EmployeeInvocationHandler implements InvocationHandler {

    // the employee that it'll proxy
    private Employee employee;

    public EmployeeInvocationHandler(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // as we cannot allow the access to setSalary
        // IllegalAccessException is being thrown here.
        if (method.getName().startsWith("setSalary")) {
            throw new IllegalAccessException("The employee cannot update their own salary.");
        }

        // as we cannot allow the access to setSalary
        // IllegalAccessException is being thrown here.
        if (method.getName().startsWith("getSubordinates")) {
            List<Employee> subordinatesFromDB = fetchSubordinatesFromDatabase();
            employee.setSubordinates(subordinatesFromDB);
        }
        return method.invoke(employee, args);
    }
    
    
    // this is dummy method used for fetching the subordinates.
    // it sleeps for a second to simulate load and then it creates two employees
    // and returns them.
    private List<Employee> fetchSubordinatesFromDatabase() throws InterruptedException {
        Thread.sleep(1000L);
        Employee e1 = new Employee();
        e1.setName("First");
        Employee e2 = new Employee();
        e2.setName("Second");
        return Arrays.asList(e1, e2);
    }

}
``` 

The method `invoke` of the `InvocationHandler` is executed whenever any method is called for the employee proxy. Inside
`invoke` there are some checks to handle our scenarios. It throws an exception when `setSalary` is called and it fills 
up the collection of subordinates whenever `getSubordinates` is called.

Now, let's test our code:

Here we create our employee variable, `actualEmployee`.
```java
Employee actualEmployee = new Employee();
```

and the proxy for the employee:
```java
IEmployee employeeProxy = (IEmployee) Proxy.newProxyInstance(
                actualEmployee.getClass().getClassLoader(),
                actualEmployee.getClass().getInterfaces(),
                new EmployeeInvocationHandler(actualEmployee)
        );
```
We've used our `EmployeeInvocationHandler` and `actualEmployee` to create the `employeeProxy`.

First check if we can call `setName` and `getName`. It should work because we've not applied any checks over it.
```java
employeeProxy.setName("A very good Name");
assertEquals("A very good Name", employeeProxy.getName());
```

Calling `setSalary` should fail:
```java
try {
    employeeProxy.setSalary(100000000);
} catch (Exception e) {
    assertEquals(IllegalAccessException.class, e.getCause().getClass());
}
```

and calling `getSubordinates` should fetch the subordinates:
```java
List<Employee> employeeList = employeeProxy.getSubordinates();
assertEquals(2, employeeList.size());
assertEquals("First", employeeList.get(0).getName());
assertEquals("Second", employeeList.get(1).getName());
```

![Class Diagram](https://www.codiwan.com/img/proxy-pattern/Class-Diagram.png)


