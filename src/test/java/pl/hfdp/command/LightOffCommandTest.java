package pl.hfdp.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class LightOffCommandTest {

    private OutputStream stream = System.out;
    private PrintStream originalStream = System.out;
    private LightOffCommand command;

    @Before
    public void setUp() {
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        command = new LightOffCommand(new Light());
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void execute() {
        command.execute();
        assertTrue(stream.toString().contains("the Light is off now"));
    }

    @Test
    public void undo() {
        command.undo();
        assertTrue(stream.toString().contains("the Light is on now"));
    }
}