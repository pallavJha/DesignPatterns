package pl.hfdp.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

public class SpeakerTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private Speaker speaker;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        speaker = new Speaker();
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void increaseVolume() {
        speaker.increaseVolume();
        assertTrue(stream.toString().contains("The volume has been increased."));
    }

    @Test
    public void decreaseVolume() {
        speaker.decreaseVolume();
        assertTrue(stream.toString().contains("The volume has been decreased."));
    }
}
