package pl.hfdp.command.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class CameraStopRecordingCommandTest {

    private OutputStream stream = System.out;
    private PrintStream originalStream = System.out;
    private CameraStopRecordingCommand command;

    @Before
    public void setUp() {
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        command = new CameraStopRecordingCommand(new Camera());
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void execute() {
        command.execute();
        assertTrue(stream.toString().contains("Recording stopped."));
    }

    @Test
    public void undo() {
        command.undo();
        assertTrue(stream.toString().contains("Recording started."));
    }
}
