package pl.hfdp.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class MacroCommandTest {

    private OutputStream stream = System.out;
    private PrintStream originalStream = System.out;
    private MacroCommand command;

    @Before
    public void setUp() {
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        command = new MacroCommand(
                new SpeakerVolIncreaseCommand(new Speaker()),
                new CameraStartRecordingCommand(new Camera()),
                new LightOnCommand(new Light())
        );
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void execute() {
        command.execute();
        assertTrue(stream.toString().contains("The volume has been increased."));
        assertTrue(stream.toString().contains("Recording started."));
        assertTrue(stream.toString().contains("the Light is on now"));
    }

    @Test
    public void undo() {
        command.undo();
        assertTrue(stream.toString().contains("the Light is off now"));
        assertTrue(stream.toString().contains("Recording stopped."));
        assertTrue(stream.toString().contains("The volume has been decreased."));
    }

}