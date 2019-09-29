package pl.hfdp.strategy.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MallardDuckTest {

    private MallardDuck mallardDuck;

    @Before
    public void setUp() {
        mallardDuck = new MallardDuck();
    }

    @After
    public void tearDown() {
        mallardDuck = null;
    }

    @Test
    public void testQuack() {
        assertEquals("Quack!", mallardDuck.quack());
    }

    @Test
    public void testSwim() {
        assertEquals("Swim!", mallardDuck.swim());
    }

    @Test
    public void testDisplay() {
        assertEquals("Looks like a Mallard Duck!", mallardDuck.display());
    }
}