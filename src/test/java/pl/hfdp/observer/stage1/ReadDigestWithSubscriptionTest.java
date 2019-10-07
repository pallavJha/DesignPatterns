package pl.hfdp.observer.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ReadDigestWithSubscriptionTest {

    private OutputStream stream;
    private PrintStream originalStream;
    private RaceCarDriver raceCarDriver = new RaceCarDriver();
    private NewsPaperMan newsPaperMan = new NewsPaperMan();
    private MovieDirector movieDirector = new MovieDirector();

    private ReadDigestWithSubscription magazine;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        magazine = new ReadDigestWithSubscription(raceCarDriver, newsPaperMan, movieDirector);
    }

    @Test
    public void generateContent() {
        magazine.generateContent();
        String content = stream.toString();
        assertEquals(4, content.split(magazine.getCurrentTitle()).length);
        assertEquals(4, content.split(magazine.getMoreInfo()).length);
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

}