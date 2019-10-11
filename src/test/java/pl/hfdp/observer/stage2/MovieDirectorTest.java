package pl.hfdp.observer.stage2;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class MovieDirectorTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private MovieDirector movieDirector;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        movieDirector = new MovieDirector();
    }

    @Test
    public void update() {
        ReadDigest readDigest = new ReadDigest();
        readDigest.generateContent();
        movieDirector.update(readDigest, null);
        TestCase.assertEquals(2, stream.toString().split(readDigest.getCurrentTitle()).length);
        TestCase.assertEquals(2, stream.toString().split(readDigest.getMoreInfo()).length);
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }
}