package pl.hfdp.strategy.stage3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RedHeadDuckTest {

    private RedHeadDuck redHeadDuck;

    @Before
    public void before() {
        redHeadDuck = new RedHeadDuck(new FlyWithWings());
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

    @Test
    public void testPerformFly() {
        assertEquals("fly with two wings", redHeadDuck.performFly());
    }
}