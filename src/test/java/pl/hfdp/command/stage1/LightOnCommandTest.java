package pl.hfdp.command.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class LightOnCommandTest {

    private OutputStream stream = System.out;
    private PrintStream originalStream = System.out;
    private LightOnCommand command;

    @Before
    public void setUp() {
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        command = new LightOnCommand(new Light());
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void execute() {
        command.execute();
        assertTrue(stream.toString().contains("the Light is on now"));
    }

    @Test
    public void undo() {
        command.undo();
        assertTrue(stream.toString().contains("the Light is off now"));
    }
}