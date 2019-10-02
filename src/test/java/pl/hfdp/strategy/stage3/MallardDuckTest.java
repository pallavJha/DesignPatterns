package pl.hfdp.strategy.stage3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MallardDuckTest {

    private MallardDuck mallardDuck;

    @Before
    public void before() {
        mallardDuck = new MallardDuck(new FlyWithWings());
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

    @Test
    public void testPerformFly() {
        assertEquals("fly with two wings", mallardDuck.performFly());
    }
}