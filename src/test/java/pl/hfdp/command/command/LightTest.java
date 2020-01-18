package pl.hfdp.command.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class LightTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private Light light;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        light = new Light();
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void turnOn() {
        light.turnOn();
        assertTrue(stream.toString().contains("the Light is on now"));
    }

    @Test
    public void turnOff() {
        light.turnOff();
        assertTrue(stream.toString().contains("the Light is off now"));
    }
}
