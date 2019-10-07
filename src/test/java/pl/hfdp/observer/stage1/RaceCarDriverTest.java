package pl.hfdp.observer.stage1;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class RaceCarDriverTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private RaceCarDriver raceCarDriver;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        raceCarDriver = new RaceCarDriver();
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void receiveNewContent() {
        raceCarDriver.receiveNewContent("title", "content");
        TestCase.assertEquals(1, stream.toString().split("title").length);
        TestCase.assertEquals(2, stream.toString().split("content").length);
    }
}