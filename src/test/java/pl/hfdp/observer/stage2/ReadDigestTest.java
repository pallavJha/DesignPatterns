package pl.hfdp.observer.stage2;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ReadDigestTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private ReadDigest readDigest;
    private RaceCarDriver raceCarDriver;
    private MovieDirector movieDirector;
    private NewsPaperMan newsPaperMan;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        readDigest = new ReadDigest();
        raceCarDriver = new RaceCarDriver();
        movieDirector = new MovieDirector();
        newsPaperMan = new NewsPaperMan();
    }

    @Test
    public void generateContent() {
        readDigest.addObserver(raceCarDriver);
        readDigest.addObserver(movieDirector);
        readDigest.addObserver(newsPaperMan);

        readDigest.generateContent();

        TestCase.assertEquals(4, stream.toString().split(readDigest.getCurrentTitle()).length);
        TestCase.assertEquals(4, stream.toString().split(readDigest.getMoreInfo()).length);
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }
}