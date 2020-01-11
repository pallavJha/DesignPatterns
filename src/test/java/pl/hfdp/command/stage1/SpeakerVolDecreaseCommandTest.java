package pl.hfdp.command.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class SpeakerVolDecreaseCommandTest {

    private OutputStream stream = System.out;
    private PrintStream originalStream = System.out;
    private SpeakerVolDecreaseCommand command;

    @Before
    public void setUp() {
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        command = new SpeakerVolDecreaseCommand(new Speaker());
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void execute() {
        command.execute();
        assertTrue(stream.toString().contains("The volume has been decreased."));
    }

    @Test
    public void undo() {
        command.undo();
        assertTrue(stream.toString().contains("The volume has been increased."));
    }

}