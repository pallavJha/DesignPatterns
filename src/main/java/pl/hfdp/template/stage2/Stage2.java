package pl.hfdp.template.stage2;

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

class TaxReport extends ReportGenerator {

    public void createDatabaseConnection() {
        System.out.println("Creating Database Connection...");
    }

    public void executeQuery() {
        System.out.println("Executing MySQL Query...");
    }

    public void convert() {
        System.out.println("Converting To PDF...");
    }
}

class ExpenseReport extends ReportGenerator {

    public void executeQuery() {
        System.out.println("Executing Postgres Query...");
    }

    public void convert() {
        System.out.println("Converting To XLS...");
    }
}