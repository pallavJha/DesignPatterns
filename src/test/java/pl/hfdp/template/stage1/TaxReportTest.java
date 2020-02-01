package pl.hfdp.template.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class TaxReportTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private TaxReport taxReport;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        taxReport = new TaxReport();
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void createDatabaseConnection() {
        taxReport.createDatabaseConnection();
        assertTrue(stream.toString().contains("Creating Database Connection..."));
    }

    @Test
    public void executeMySQLQuery() {
        taxReport.executeMySQLQuery();
        assertTrue(stream.toString().contains("Executing MySQL Query..."));
    }

    @Test
    public void convertToPDF() {
        taxReport.convertToPDF();
        assertTrue(stream.toString().contains("Converting To PDF..."));
    }

    @Test
    public void generate() {
        taxReport.generate();
        assertTrue(stream.toString().contains("Creating Database Connection..."));
        assertTrue(stream.toString().contains("Executing MySQL Query..."));
        assertTrue(stream.toString().contains("Converting To PDF..."));
    }
}