package pl.hfdp.observer.stage1;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class NewsPaperManTest {

    private OutputStream stream;
    private PrintStream originalStream = System.out;
    private NewsPaperMan newsPaperMan;

    @Before
    public void setUp() {
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        newsPaperMan = new NewsPaperMan();
    }

    @After
    public void tearDown() {
        System.setOut(originalStream);
    }

    @Test
    public void receiveNewArticle() {
        newsPaperMan.receiveNewArticle("title", "content");
        TestCase.assertEquals(2, stream.toString().split("title").length);
        TestCase.assertEquals(2, stream.toString().split("content").length);
    }
}