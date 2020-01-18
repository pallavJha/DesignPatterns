package pl.hfdp.command.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class CameraTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private Camera camera;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        camera = new Camera();
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void startRecording() {
        camera.startRecording();
        assertTrue(stream.toString().contains("Recording started."));
    }

    @Test
    public void stopRecording() {
        camera.stopRecording();
        assertTrue(stream.toString().contains("Recording stopped."));
    }
}