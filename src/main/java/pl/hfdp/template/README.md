In this tutorial we'll be learning **Template Design Pattern**.

We'll try to create a Report Generator that will generate Tax Report and Expense Report.

In this section we'll be creating two classes. One for Tax Report Generation and another for Expense Report
Generation.
##### Tax Report

The TaxReport class. It has a generate method that'll do the following tasks:
- Create MySQL Database Connection
- Execute a Query to Fetch some Tax related details from the Database
- Convert the result to a PDF document.
```java
class TaxReport {
    public void generate() {
        createDatabaseConnection();
        executeMySQLQuery();
        convertToPDF();
    }

    public void createDatabaseConnection() {
        System.out.println("Creating Database Connection...");
    }

    public void executeMySQLQuery() {
        System.out.println("Executing MySQL Query...");
    }

    public void convertToPDF() {
        System.out.println("Converting To PDF...");
    }
}
```

##### Expense Report

The ExpenseReport class. It has a generate method that'll do the following tasks:
- Create Postgres Database Connection
- Execute a Query to Fetch some Tax related details from the Database
- Convert the result to a XLS document.
```java
class ExpenseReport {
    public void generate() {
        createDatabaseConnection();
        executePostgresQuery();
        convertToXLS();
    }

    public void createDatabaseConnection() {
        System.out.println("Creating Database Connection...");
    }

    public void executePostgresQuery() {
        System.out.println("Executing Postgres Query...");
    }

    public void convertToXLS() {
        System.out.println("Converting To XLS...");
    }
}
```
After performing a quick code review we've got following points to ponder:
- The `createDatabaseConnection` methods in both the classes share the same responsibility, i.e., to create a database 
connection.
- Same with the methods `convertToPDF` and `convertToXLS`. However, their implementations are different but their 
  intention is same, to convert to a format.
- **The way both of them work is same, i.e.,**
    1. Create a DB connection
    2. Execute a Query
    3. Convert the data received from the Query Response to a presentable format, i.e., XLS or PDF

**It seems like there is code duplication(or behaviour duplication?).**
The first thing that comes into the mind is to remove it by creating an abstract class that will hold the common 
attributes.

So, this is what we've created after the review, a new `ReportGenerator` class
```java
abstract class ReportGenerator {

    final public void generate() {
        createDatabaseConnection();
        executeQuery();
        convert();
    }

    public void createDatabaseConnection() {
        System.out.println("Creating Database Connection...");
    }

    abstract public void executeQuery();

    abstract public void convert();
}
```
Two methods, `executeQuery` and `convert`, are abstract and the concrete classes must provide the implementation.
But there's an implementation for `createDatabaseConnection` because this property will remain same for all the concrete
implementations, although, it can be overridden by them.
And following are the implementations for:
- TaxReport
```java
class TaxReport extends ReportGenerator {

    public void executeQuery() {
        System.out.println("Executing MySQL Query...");
    }

    public void convert() {
        System.out.println("Converting To PDF...");
    }
}
```
- Expense Report
```java
class ExpenseReport extends ReportGenerator {
    
    public void createDatabaseConnection() {
            System.out.println("Creating Database Connection...");
    }

    public void executeQuery() {
        System.out.println("Executing Postgres Query...");
    }

    public void convert() {
        System.out.println("Converting To XLS...");
    }
}
```

Here, we've generalized and abstracted the `createConnection` method as it remains same for both the classes.
Also, we've **templatized** the way a report is generated, i.e., combining the task: 
- Create a connection
- Execute a Query
- Convert the data received from the Query Response to a presentable format, i.e., XLS or PDF

into the method `generate()`.

We've delegated the task of executing the Query and converting the response to desired format.
This way the algorithm of **creating a report**  remains same, the `generate` method, but the subclasses can redefine the
steps but it cannot updated the structure of the algorithm.