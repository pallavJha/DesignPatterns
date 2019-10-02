package pl.hfdp.strategy.stage2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

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
    public void quack() {
        assertEquals("Quack!", redHeadDuck.quack());
    }

    @Test
    public void swim() {
        assertEquals("Swim!", redHeadDuck.swim());
    }

    @Test
    public void display() {
        assertEquals("Red head Duck has a red head!", redHeadDuck.display());
    }

    @Test
    public void fly() {
        assertEquals("Fly!", redHeadDuck.fly());
    }
}