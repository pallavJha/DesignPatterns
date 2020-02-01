package pl.hfdp.template.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class ExpenseReportTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private ExpenseReport expenseReport;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        expenseReport = new ExpenseReport();
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void createDatabaseConnection() {
        expenseReport.createDatabaseConnection();
        assertTrue(stream.toString().contains("Creating Database Connection..."));
    }

    @Test
    public void executeMySQLQuery() {
        expenseReport.executePostgresQuery();
        assertTrue(stream.toString().contains("Executing Postgres Query..."));
    }

    @Test
    public void convertToPDF() {
        expenseReport.convertToXLS();
        assertTrue(stream.toString().contains("Converting To XLS..."));
    }

    @Test
    public void generate() {
        expenseReport.generate();
        assertTrue(stream.toString().contains("Creating Database Connection..."));
        assertTrue(stream.toString().contains("Executing Postgres Query..."));
        assertTrue(stream.toString().contains("Converting To XLS..."));
    }
}