package pl.hfdp.template.stage1;

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