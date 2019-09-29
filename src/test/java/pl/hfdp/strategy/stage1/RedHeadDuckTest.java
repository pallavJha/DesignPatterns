package pl.hfdp.strategy.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedHeadDuckTest {

    private RedHeadDuck redHeadDuck;

    @Before
    public void setUp() {
        redHeadDuck = new RedHeadDuck();
    }

    @After
    public void tearDown() {
        redHeadDuck = null;
    }

    @Test
    public void testQuack() {
        assertEquals("Quack!", redHeadDuck.quack());
    }

    @Test
    public void testSwim() {
        assertEquals("Swim!", redHeadDuck.swim());
    }

    @Test
    public void testDisplay() {
        assertEquals("Red head Duck has a red head!", redHeadDuck.display());
    }
}